package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationdesky.entities.Moniteur;
@Repository
public interface MoniteurRepo extends JpaRepository<Moniteur,Long> {
}
