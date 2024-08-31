import { Injectable } from '@angular/core';
import { API_BASE_URL } from '../app.config';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = API_BASE_URL;

  constructor(private http: HttpClient) { }

  postData(data: any, methodeUrl: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const url = this.apiUrl + methodeUrl;
    return this.http.post<any>(url, data, {headers});
  }

  getAll(methodeUrl: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const url = this.apiUrl + methodeUrl;
    return this.http.get<any>(url, {headers});
  }

  getById(methodeUrl: string, id: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const url = this.apiUrl + methodeUrl + id;
    return this.http.get<any>(url, {headers});
  }

  getByString(methodeUrl: string, value: string): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const url = this.apiUrl + methodeUrl + value;
    return this.http.get<any>(url, {headers});
  }

  checkNewEmail(email: string): Observable<boolean> {
    const url = this.apiUrl + "/api/auth/isnewemail/" + email;

    return this.http.get<boolean>(url);
  }

  checkNewPseudo(pseudo: string): Observable<boolean> {
    const url = this.apiUrl+ "/api/auth/isnewpseudo/" + pseudo;
    return this.http.get<boolean>(url);
  }

}
