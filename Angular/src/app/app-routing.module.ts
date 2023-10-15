import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListComponent} from "./etudiant/list/list.component";
import {AddEComponent} from "./etudiant/add-e/add-e.component";

const routes: Routes = [
  { path: '', redirectTo: '/etudiants', pathMatch: 'full' },
  { path: 'etudiants', component: ListComponent },
  { path: 'add-etudiant', component: AddEComponent },
  // Add more routes for other components/pages as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
