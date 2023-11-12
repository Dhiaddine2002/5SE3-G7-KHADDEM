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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UniversiteServiceImplTest {
    @Autowired
    private UniversiteServiceImpl universiteService;

    @MockBean
    private UniversiteRepository universiteRepository;

    @MockBean
    private DepartementRepository departementRepository;

    @Test
    public void testRetrieveAllUniversites() {
        List<Universite> universites = new ArrayList<>();
        universites.add(new Universite(1, "Universite 1", new ArrayList<>()));
        universites.add(new Universite(2, "Universite 2", new ArrayList<>()));
        when(universiteRepository.findAll()).thenReturn(universites);

        List<Universite> result = universiteService.retrieveAllUniversites();

        assertEquals(universites, result);
    }

    @Test
    public void testAddUniversite() {
        Universite universite = new Universite(1, "Universite 1", new ArrayList<>());
        when(universiteRepository.save(universite)).thenReturn(universite);

        Universite result = universiteService.addUniversite(universite);

        assertEquals(universite, result);
    }

    @Test
    public void testUpdateUniversite() {
        Universite universite = new Universite(1, "Universite 1", new ArrayList<>());
        when(universiteRepository.save(universite)).thenReturn(universite);

        Universite result = universiteService.updateUniversite(universite);

        assertEquals(universite, result);
    }

    @Test
    public void testRetrieveUniversite() {
        Integer universiteId = 1;
        Universite universite = new Universite(universiteId, "ESPRIT", new ArrayList<>());
        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(universite));

        Universite result = universiteService.retrieveUniversite(universiteId);

        assertEquals(universite, result);
    }

    @Test
    public void testAssignUniversiteToDepartement() {
        Integer universiteId = 1;
        Integer departementId = 1;

        Universite universite = new Universite(universiteId, "ESPRIT", new ArrayList<>());
        Departement departement = new Departement(departementId, "Informatique", new ArrayList<>());

        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(universite));
        when(departementRepository.findById(departementId)).thenReturn(Optional.of(departement));

        universiteService.assignUniversiteToDepartement(universiteId, departementId);

        verify(universiteRepository).findById(universiteId);
        verify(departementRepository).findById(departementId);

        assertEquals(1, universite.getDepartements().size());
    }
}
