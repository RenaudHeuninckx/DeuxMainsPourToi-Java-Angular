import { IMassage } from './../../model/imassage';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { IComment } from '../../model/icomment';
import { AuthService } from '../../services/auth.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-massage-detail',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CurrencyPipe
  ],
  templateUrl: './massage-detail.component.html',
  styleUrl: './massage-detail.component.scss'
})
export class MassageDetailComponent implements OnInit {

  massage!: IMassage;
  loggedPseudo!: string;
  loggedIn!: boolean;
  loggedId!: string;
  methodeUrl = "/api/massage/get/";
  commentUrl = "/api/comment/massage/";
  isError: boolean = false;
  errorMessage!: string;
  comments!: IComment[];
  massageId!: number;
  commentaire = "";

  constructor(private route: ActivatedRoute,
    private apiService: ApiService,
    private router: Router,
    private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.loggedPseudo$.subscribe(loggedPseudo => {
      this.loggedPseudo = loggedPseudo;
    });

    this.authService.loggedIn$.subscribe(loggedIn => {
      this.loggedIn = loggedIn;
    });
/* 
    this.authService.loggedId$.subscribe(loggedId => {
      this.loggedId = loggedId;
    }); */

    this.massageId = Number(this.route.snapshot.paramMap.get('id'));

    this.apiService.getById(this.methodeUrl, this.massageId).subscribe(
      (data) => {
        this.massage = data;
      },
      (error) => {
        this.isError = true;
        this.errorMessage = "Problème de chargement du massage ! " + error;
      }
    )

    this.apiService.getById(this.commentUrl, this.massageId).subscribe(
      (dataComments) => {
        this.comments = dataComments;
      },
      (error) => {
        this.isError = true;
        this.errorMessage = "Problème de chargement des commentaires ! " + error;
      }
    )
  }

  addComment(): void {
    const newComment: any = {
      commentaire: this.commentaire,
      massageId: this.massageId,
      creationDate: "",
      modifiedDate: "",
      utilisateur: 0
    }
    const methodeUrl = "/api/comment/create";

    this.commentaire = '';

  }

  retour() {
    this.router.navigateByUrl('massage');
  }

}
