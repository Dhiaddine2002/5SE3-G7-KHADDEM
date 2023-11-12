package tn.esprit.spring.khaddem.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.khaddem.entities.*;
import tn.esprit.spring.khaddem.repositories.ContratRepository;
import tn.esprit.spring.khaddem.repositories.DepartementRepository;
import tn.esprit.spring.khaddem.repositories.EquipeRepository;
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
public class EquipeServiceImplTest {

    @Autowired
    private EquipeServiceImpl equipeService;
    @MockBean
    private ContratRepository contratRepository ;

    @MockBean
    private EquipeRepository equipeRepository;

    @Test
    public void testRetrieveAllEquipes() {
        List<Equipe> equipes = new ArrayList<>();
        equipes.add(Equipe.builder().idEquipe(1).nomEquipe("Equipe 1").niveau(Niveau.JUNIOR).etudiants(new ArrayList<>()).build());
        equipes.add(Equipe.builder().idEquipe(2).nomEquipe("Equipe 2").niveau(Niveau.JUNIOR).etudiants(new ArrayList<>()).build());
        when(equipeRepository.findAll()).thenReturn(equipes);

        List<Equipe> result = equipeRepository.retrieveAllEquipes();

        assertEquals(equipes, result);
    }

    @Test
    public void testAddEquipe() {
        Equipe equipe = new Equipe(1, "Departement 1", Niveau.JUNIOR, new ArrayList<>(), null);
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe result = equipeRepository.addEquipe(equipe);

        assertEquals(equipe, result);
    }

    @Test
    public void testUpdateEquipe() {
        Equipe equipe = new Equipe(1, "Departement 1", Niveau.JUNIOR, new ArrayList<>(), null);
        when(equipeRepository.save(equipe)).thenReturn(equipe);

        Equipe result = equipeService.updateEquipe(equipe);

        assertEquals(equipe, result);
    }

}
