package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.khaddem.entities.Departement;
import tn.esprit.spring.khaddem.entities.Universite;
import tn.esprit.spring.khaddem.repositories.DepartementRepository;
import tn.esprit.spring.khaddem.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class DepartementServiceImplTest {
    @Autowired
    private DepartementServiceImpl departementService;
    @MockBean
    private UniversiteRepository universiteRepository ;

    @MockBean
    private DepartementRepository departementRepository;

    @Test
     void testRetrieveAllDepartements() {
        List<Departement> departements = new ArrayList<>();
        departements.add(new Departement(1, "Departement 1", new ArrayList<>()));
        departements.add(new Departement(2, "Departement 2", new ArrayList<>()));
        when(departementRepository.findAll()).thenReturn(departements);

        List<Departement> result = departementService.retrieveAllDepartements();

        assertEquals(departements, result);
    }

    @Test
     void testAddDepartement() {
        Departement departement = new Departement(1, "Departement 1", new ArrayList<>());
        when(departementRepository.save(departement)).thenReturn(departement);

        Departement result = departementService.addDepartement(departement);

        assertEquals(departement, result);
    }
    @Test
     void testUpdateDepartement() {
        Departement departement = new Departement(1, "Departement 1", new ArrayList<>());
        when(departementRepository.save(departement)).thenReturn(departement);

        Departement result = departementService.updateDepartement(departement);

        assertEquals(departement, result);
    }

    @Test
     void testRetrieveDepartementsByUniversite() {
        Integer universiteId = 1;

        Universite universite = new Universite();
        universite.setIdUniversite(universiteId);
        universite.setNomUniv("ESPRIT");
        universite.setDepartements(new ArrayList<>());

        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(universite));

        List<Departement> departements = departementService.retrieveDepartementsByUniversite(universiteId);

        verify(universiteRepository).findById(universiteId);

        assertTrue(departements.isEmpty());
    }
}