import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, ValidationErrors, Validators } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Router } from '@angular/router';
import { catchError, map, Observable, of, switchMap } from 'rxjs';

@Component({
  selector: 'app-enregistrement',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './enregistrement.component.html',
  styleUrl: './enregistrement.component.scss'
})
export class EnregistrementComponent implements OnInit {

  pseudo!: string;
  email!: string;
  password!: string;
  isNewsletter: boolean = false;
  isAdmin: boolean = false;
  errorMessage!: string;
  registerForm!: FormGroup;

  constructor(private apiService: ApiService, private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      pseudo: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      /* pseudo: ['', [Validators.required], [this.newPseudoValidator.bind(this)]],
      email: ['', [Validators.required, Validators.email], [this.newEmailValidator.bind(this)]], */
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
      isNewsletter : []
    }, {
      validators: this.passwordMatchValidator
    });
  }

  /* newEmailValidator(control: AbstractControl): Observable<ValidationErrors | null> {
    return control.valueChanges.pipe(
      switchMap(email => this.apiService.checkNewEmail(email)),
      map(exists => exists ? { newEmail: true } : null)
    );
  }

  newPseudoValidator(control: AbstractControl): Observable<ValidationErrors | null> {
    return control.valueChanges.pipe(
      switchMap(pseudo => this.apiService.checkNewPseudo(pseudo)),
      map(exists => exists ? { newPseudo: true } : null)
    );
  } */

  passwordMatchValidator(group: AbstractControl): ValidationErrors | null {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { passwordsMismatch: true };
  }

  onSubmit() {
    const data = {
      pseudo: this.registerForm.value.pseudo,
      email: this.registerForm.value.email,
      password: this.registerForm.value.password,
      newsletter: this.registerForm.value.isNewsletter === null ? false : this.registerForm.value.isNewsletter,
      admin: this.isAdmin
     }
    const methodUrl = "/api/auth/register";

    if (this.registerForm.valid) {
      this.apiService.postData(data, methodUrl).subscribe({
        next: (reponse) => {
          console.log(reponse);
          this.router.navigate(['/home'])
        },
        error: (error) => {
          this.errorMessage = "Problème avec l'enregistrement : " + JSON.stringify(error);
        }
      })
    } else {
      this.errorMessage = "Formulaire invalide";
    }

  }
}
