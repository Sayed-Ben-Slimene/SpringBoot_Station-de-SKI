package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationdesky.entities.Piste;

public interface PisteRepo extends JpaRepository<Piste,Long> {
}
