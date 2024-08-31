import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {

  loggedIn: boolean= false;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
      this.authService.loggedIn$.subscribe(loggedIn =>{
        this.loggedIn = loggedIn;
      });
  }

  connexion() {
    this.router.navigateByUrl('connexion');
  }

  enregistrement() {
    this.router.navigateByUrl('enregistrement');
  }

  monCompte() {
    this.router.navigateByUrl('moncompte');
  }

  deconnexion() {
    this.authService.logout();
    this.router.navigateByUrl('home');
  }

}
