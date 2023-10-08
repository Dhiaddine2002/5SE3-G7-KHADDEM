import { Component } from '@angular/core';
import { EtudiantService } from '../../_service/etudiant-service.service'; // Update the path
import { Etudiant } from '../../_model/Etudiant';
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-e',
  templateUrl: './add-e.component.html',
  styleUrls: ['./add-e.component.css']
})
export class AddEComponent {
  newEtudiant: Etudiant = new Etudiant(); // Initialize a new Etudiant object

  constructor(private etudiantService: EtudiantService, private rout:Router) { }

  onSubmit(): void {
    this.etudiantService.addEtudiant(this.newEtudiant).subscribe(
      (addedEtudiant) => {
        console.log('Student added successfully:', addedEtudiant);
        alert('Student added successfully');
        this.rout.navigate(['']);
        this.newEtudiant = new Etudiant();
      },
      (error) => {
        console.error('Error adding student:', error);
      }
    );
  }
}
