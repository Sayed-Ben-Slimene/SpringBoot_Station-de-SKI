package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationdesky.entities.Piste;
@Repository
public interface PisteRepo extends JpaRepository<Piste,Long> {
}
