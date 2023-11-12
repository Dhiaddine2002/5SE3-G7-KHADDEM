package tn.esprit.spring.kaddem.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.List;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DepartementServiceImplTest {
    @Autowired
    IDepartementService ds;
    @Test
    @Order(1)
    public void testRetrieveAllDepartement() {
        List<Departement> listes = ds.retrieveAllDepartements();

        Assertions.assertEquals(0, listes.size());
    }
}
