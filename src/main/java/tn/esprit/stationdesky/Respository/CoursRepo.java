package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationdesky.entities.Cours;

public interface CoursRepo extends JpaRepository<Cours,Long> {
}
