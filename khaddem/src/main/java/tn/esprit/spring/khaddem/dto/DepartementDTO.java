package tn.esprit.spring.khaddem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.khaddem.entities.Etudiant;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartementDTO implements Serializable {
    private Integer idDepartement;
    private String nomDepart;
    private List<Etudiant> etudiants;
}
