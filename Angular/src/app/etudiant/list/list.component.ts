import { Component, OnInit } from '@angular/core';
import {Etudiant} from "../../_model/Etudiant";
import {EtudiantService} from "../../_service/etudiant-service.service"; // Update the path

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  etudiants: Etudiant[] = [];

  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {
    this.loadEtudiants();
  }

  loadEtudiants(): void {
    this.etudiantService.getAllEtudiants().subscribe(data => {
      this.etudiants = data;
    });
  }

  // Implement methods to add, update, and delete etudiants
}
