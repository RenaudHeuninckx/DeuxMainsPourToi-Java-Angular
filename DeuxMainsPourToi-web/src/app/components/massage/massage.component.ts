import { Component, OnInit } from '@angular/core';
import { IMassage } from '../../model/imassage';
import { ApiService } from '../../services/api.service';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-massage',
  standalone: true,
  imports: [
    CommonModule,
    CurrencyPipe
  ],
  templateUrl: './massage.component.html',
  styleUrl: './massage.component.scss'
})

export class MassageComponent implements OnInit {

  massages!: IMassage[];
  methodeUrl: string = "/api/massage/";
  isError: boolean = false;
  errorMessage!: string;

  constructor(private apiservice: ApiService, private router: Router) {}

  ngOnInit(): void {
    this.apiservice.getAll(this.methodeUrl).subscribe({
      next: (data) => {
        this.massages = data;
      },
      error: (error) => {
        this.isError = true;
        this.errorMessage = "Problème de chargement des massages ! " + error;
      }
    })
  }

  selectMassage(massage: IMassage): void {
    this.router.navigate(['/massageDetail', massage.id]);
  }

}
