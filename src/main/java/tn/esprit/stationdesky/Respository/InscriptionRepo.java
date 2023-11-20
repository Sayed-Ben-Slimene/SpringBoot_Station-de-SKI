package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Inscription;

import java.util.List;

public interface InscriptionRepo extends JpaRepository<Inscription,Long> {
    List<Inscription> findByCours(Cours cours);

}
