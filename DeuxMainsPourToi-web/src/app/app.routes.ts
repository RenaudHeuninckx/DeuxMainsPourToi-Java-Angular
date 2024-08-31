import { Routes } from '@angular/router';
import { ConnexionComponent } from './components/connexion/connexion.component';
import { EnregistrementComponent } from './components/enregistrement/enregistrement.component';
import { HomeComponent } from './components/home/home.component';
import { EspaceDetenteComponent } from './components/espace-detente/espace-detente.component';
import { MassageComponent } from './components/massage/massage.component';
import { MassageDetailComponent } from './components/massage-detail/massage-detail.component';
import { PackOffreComponent } from './components/pack-offre/pack-offre.component';
import { PackOffreDetailComponent } from './components/pack-offre-detail/pack-offre-detail.component';
import { EvenementComponent } from './components/evenement/evenement.component';
import { EvenementDetailComponent } from './components/evenement-detail/evenement-detail.component';
import { ActualiteComponent } from './components/actualite/actualite.component';
import { ActualiteDetailComponent } from './components/actualite-detail/actualite-detail.component';
import { PresseComponent } from './components/presse/presse.component';
import { MonCompteComponent } from './components/mon-compte/mon-compte.component';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'connexion', component: ConnexionComponent},
  {path: 'enregistrement', component: EnregistrementComponent},
  {path: 'moncompte', component: MonCompteComponent},
  {path: 'espaceDetente', component: EspaceDetenteComponent},
  {path: 'massage', component: MassageComponent},
  {path: 'massageDetail/:id', component: MassageDetailComponent},
  {path: 'packOffre', component: PackOffreComponent},
  {path: 'packOffreDetail/:id', component: PackOffreDetailComponent},
  {path: 'evenement', component: EvenementComponent},
  {path: 'evenementDetail/:id', component: EvenementDetailComponent},
  {path: 'actualite', component: ActualiteComponent},
  {path: 'actualiteDetail/:id', component: ActualiteDetailComponent},
  {path: 'presse', component: PresseComponent},
];
