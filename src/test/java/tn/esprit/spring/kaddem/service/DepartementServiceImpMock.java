package tn.esprit.spring.kaddem.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class DepartementServiceImpMock {
    @Mock
    DepartementRepository DRepository = Mockito.mock(DepartementRepository.class);
    @InjectMocks
    IDepartementService DService;
    Departement D = new Departement(1, "abc");
    List<Departement> listDeps = new ArrayList<Departement>() {
        {
            add(new Departement(2, "abcd"));
            add(new Departement(3, "abcde"));

        }
    };
    @Test
    public void testRetrieveSubscriptions() {
        Mockito.when(DRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(D));
        Departement dep = DService.retrieveDepartement(1);
        Assertions.assertNotNull(dep);
    }
}



