package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.khaddem.entities.*;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.DepartementRepository;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;
import tn.esprit.spring.khaddem.repositories.EtudiantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class EtudiantServiceImplTest {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Mock
    private DepartementRepository departementRepository;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EquipeRepository equipeRepository;

    @Test
    void retrieveAllEtudiants() {
        // Arrange
        List<Etudiant> expectedEtudiants = new ArrayList<>();
        when(etudiantRepository.findAll()).thenReturn(expectedEtudiants);

        // Act
        List<Etudiant> actualEtudiants = etudiantService.retrieveAllEtudiants();

        // Assert
        assertEquals(expectedEtudiants, actualEtudiants);
        verify(etudiantRepository, times(1)).findAll();
    }

    @Test
    void addEtudiant() {
        // Arrange
        Etudiant etudiantToAdd = new Etudiant(); // Create a sample etudiant
        when(etudiantRepository.save(etudiantToAdd)).thenReturn(etudiantToAdd);

        // Act
        Etudiant addedEtudiant = etudiantService.addEtudiant(etudiantToAdd);

        // Assert
        assertEquals(etudiantToAdd, addedEtudiant);
        verify(etudiantRepository, times(1)).save(etudiantToAdd);
    }

    @Test
    void updateEtudiant() {
        // Arrange
        Etudiant etudiantToUpdate = new Etudiant(); // Create a sample etudiant
        when(etudiantRepository.save(etudiantToUpdate)).thenReturn(etudiantToUpdate);

        // Act
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiantToUpdate);

        // Assert
        assertEquals(etudiantToUpdate, updatedEtudiant);
        verify(etudiantRepository, times(1)).save(etudiantToUpdate);
    }

    @Test
    void retrieveEtudiant() {
        // Arrange
        Etudiant expectedEtudiant = new Etudiant(); // Create a sample etudiant
        when(etudiantRepository.findById(anyInt())).thenReturn(Optional.of(expectedEtudiant));

        // Act
        Etudiant actualEtudiant = etudiantService.retrieveEtudiant(1);

        // Assert
        assertEquals(expectedEtudiant, actualEtudiant);
        verify(etudiantRepository, times(1)).findById(1);
    }


    @Test
    void removeEtudiant() {
        // Arrange
        int etudiantIdToRemove = 1;

        // Act
        etudiantService.removeEtudiant(etudiantIdToRemove);

        // Assert
        verify(etudiantRepository, times(1)).deleteById(etudiantIdToRemove);
    }

    @Test
    void assignEtudiantToDepartement() {
        // Arrange
        int etudiantId = 1;
        int departementId = 2;
        Etudiant etudiant = new Etudiant();
        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(etudiant));
        when(departementRepository.findById(departementId)).thenReturn(Optional.of(new Departement()));

        // Act
        etudiantService.assignEtudiantToDepartement(etudiantId, departementId);

        // Assert
        assertEquals(departementId, etudiant.getDepartement().getIdDepartement());
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    void findByDepartementIdDepartement() {
        // Arrange
        int departementId = 1;
        List<Etudiant> etudiantsInDepartement = new ArrayList<>();
        when(etudiantRepository.findByDepartementIdDepartement(departementId)).thenReturn(etudiantsInDepartement);

        // Act
        List<Etudiant> resultEtudiants = etudiantService.findByDepartementIdDepartement(departementId);

        // Assert
        assertEquals(etudiantsInDepartement, resultEtudiants);
        verify(etudiantRepository, times(1)).findByDepartementIdDepartement(departementId);
    }

    @Test
    void findByEquipesNiveau() {
        // Arrange
        Niveau niveau = Niveau.JUNIOR; // Replace with the desired niveau
        List<Etudiant> expectedEtudiants = new ArrayList<>();
        when(etudiantRepository.findByEquipesNiveau(niveau)).thenReturn(expectedEtudiants);

        // Act
        List<Etudiant> actualEtudiants = etudiantService.findByEquipesNiveau(niveau);

        // Assert
        assertEquals(expectedEtudiants, actualEtudiants);
        verify(etudiantRepository, times(1)).findByEquipesNiveau(niveau);
    }

    @Test
    void retrieveEtudiantsByContratSpecialite() {
        // Arrange
        Specialite specialite = Specialite.IA; // Replace with the desired specialite
        List<Etudiant> expectedEtudiants = new ArrayList<>();
        when(etudiantRepository.retrieveEtudiantsByContratSpecialite(specialite)).thenReturn(expectedEtudiants);

        // Act
        List<Etudiant> actualEtudiants = etudiantService.retrieveEtudiantsByContratSpecialite(specialite);

        // Assert
        assertEquals(expectedEtudiants, actualEtudiants);
        verify(etudiantRepository, times(1)).retrieveEtudiantsByContratSpecialite(specialite);
    }

    @Test
    void retrieveEtudiantsByContratSpecialiteSQL() {
        // Arrange
        String specialite = "Computer Science"; // Replace with the desired specialite
        List<Etudiant> expectedEtudiants = new ArrayList<>();
        when(etudiantRepository.retrieveEtudiantsByContratSpecialiteSQL(specialite)).thenReturn(expectedEtudiants);

        // Act
        List<Etudiant> actualEtudiants = etudiantService.retrieveEtudiantsByContratSpecialiteSQL(specialite);

        // Assert
        assertEquals(expectedEtudiants, actualEtudiants);
        verify(etudiantRepository, times(1)).retrieveEtudiantsByContratSpecialiteSQL(specialite);
    }

    @Test
    void addAndAssignEtudiantToEquipeAndContract() {
        // Arrange
        Etudiant etudiantToSave = new Etudiant();
        Integer idContrat = 1;
        Integer idEquipe = 2;

        Contrat contrat = new Contrat();
        contrat.setIdContrat(idContrat);

        Equipe equipe = new Equipe();
        equipe.setIdEquipe(idEquipe);

        when(contratRepository.findById(idContrat)).thenReturn(Optional.of(contrat));
        when(equipeRepository.findById(idEquipe)).thenReturn(Optional.of(equipe));
        when(etudiantRepository.save(any())).thenReturn(etudiantToSave);

        // Act
        Etudiant resultEtudiant = etudiantService.addAndAssignEtudiantToEquipeAndContract(etudiantToSave, idContrat, idEquipe);

        // Assert
        assertEquals(etudiantToSave, resultEtudiant);
        assertEquals(1, resultEtudiant.getContrats().size());
        assertTrue(resultEtudiant.getContrats().contains(contrat)); // Check that the expected contract is in the list

        assertEquals(1, resultEtudiant.getEquipes().size());
        assertEquals(equipe, resultEtudiant.getEquipes().get(0));

        verify(etudiantRepository, times(1)).save(etudiantToSave);
        verify(contratRepository, times(1)).findById(idContrat);
        verify(equipeRepository, times(1)).findById(idEquipe);

    }

    @Test
    void getEtudiantsByDepartement() {
        // Arrange
        int idDepartement = 1; // Replace with the desired departement ID
        Departement departement = new Departement();
        List<Etudiant> expectedEtudiants = new ArrayList<>();
        when(departementRepository.findById(idDepartement)).thenReturn(Optional.of(departement));
        when(etudiantRepository.findByDepartementIdDepartement(idDepartement)).thenReturn(expectedEtudiants);

        // Act
        List<Etudiant> actualEtudiants = etudiantService.getEtudiantsByDepartement(idDepartement);

        // Assert
        assertEquals(expectedEtudiants, actualEtudiants);
    }
}
