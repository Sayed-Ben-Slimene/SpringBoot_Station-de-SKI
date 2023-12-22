package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationdesky.entities.Cours;
@Repository
public interface CoursRepo extends JpaRepository<Cours,Long> {
}
