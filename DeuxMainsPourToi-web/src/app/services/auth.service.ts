import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { IUser } from '../model/iuser';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private loggedIn = new BehaviorSubject<boolean>(this.isLoggedIn());

  loggedIn$ = this.loggedIn.asObservable();

  isLoggedIn(): boolean {
    return sessionStorage.getItem('logged') === 'true';
  }

  private loggedAdmin = new BehaviorSubject<boolean>(this.isLoggedAdmin());

  loggedAdmin$ = this.loggedAdmin.asObservable();

  isLoggedAdmin(): boolean {
    return sessionStorage.getItem('role') === 'ADMIN';
  }

  private loggedPseudo = new BehaviorSubject<string>(this.getLoggedPseudo());

  loggedPseudo$ = this.loggedPseudo.asObservable();

  getLoggedPseudo(): string {
    const item = sessionStorage.getItem('pseudo')
    return item ? item : 'inconnu';
  }

  getLoggedId(): string {
    const item = sessionStorage.getItem('id')
    return item ? item : '0';
  }

  login(user: IUser) {
    sessionStorage.setItem('logged', 'true');
    sessionStorage.setItem('role', user.roles[0].authority);
    sessionStorage.setItem('pseudo', user.pseudo);
    sessionStorage.setItem('id', String(user.Id));
    sessionStorage.setItem('email', user.sub);
    this.loggedIn.next(true);
  }

  logout() {
    sessionStorage.removeItem('logged');
    sessionStorage.removeItem('role');
    sessionStorage.removeItem('pseudo');
    sessionStorage.removeItem('id');
    sessionStorage.removeItem('email');
    this.loggedIn.next(false);
  }

}
