package tn.esprit.spring.khaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.khaddem.entities.DetailEquipe;
import tn.esprit.spring.khaddem.entities.Equipe;

import java.util.List;

@Repository
public interface EquipeRepository  extends JpaRepository<Equipe, Integer> {

    @Query("SELECT e FROM Equipe e")
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe equipe);



}
