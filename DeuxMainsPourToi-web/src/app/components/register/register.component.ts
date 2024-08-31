import { ApiService } from './../../services/api.service';
import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  standalone: true,
  imports: [FormsModule],
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  user: any = { username: '', password: '', email: '' };

  constructor(private apiService: ApiService, private router: Router) { }

  register() {
    const methodeUrl = "/api/auth/register";
    this.apiService.postData(this.user,methodeUrl).subscribe({
      next: () => {
        this.router.navigate(['/login']);
      },
      error: () => {
        console.error('Registration error: ', Error);
      }
    });
  }
}
