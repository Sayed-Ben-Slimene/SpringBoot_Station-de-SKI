package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationdesky.entities.Moniteur;

public interface MoniteurRepo extends JpaRepository<Moniteur,Long> {
}
