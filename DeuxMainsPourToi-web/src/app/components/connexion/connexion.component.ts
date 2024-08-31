import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { IUser } from '../../model/iuser';
import { jwtDecode } from 'jwt-decode';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-connexion',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './connexion.component.html',
  styleUrl: './connexion.component.scss'
})
export class ConnexionComponent {

  email!: string;
  password!: string;
  errorMessage!: string;

  constructor(private apiService: ApiService, private authService: AuthService, private router: Router) {}

  onSubmitForm() {
    const data = {
      email: this.email,
      password: this.password
    }
    const methodeUrl = "/api/auth/login"

    this.apiService.postData(data, methodeUrl).subscribe({
      next: (reponse) => {
        const decodedToken = this.parseJwt(reponse.token);
        const user: IUser = decodedToken;
        this.authService.login(user);
        this.router.navigate(['/home']);
      },
      error: () => {
        this.errorMessage = 'Nom d\'utilisateur ou mot de passe incorrect';
      }
    })
  }

  private parseJwt(token: string): any {
    return jwtDecode(token);
  }

}

