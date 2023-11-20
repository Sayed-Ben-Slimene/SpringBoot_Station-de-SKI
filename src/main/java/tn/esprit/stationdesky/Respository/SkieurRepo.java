package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stationdesky.entities.Skieur;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.util.List;

public interface SkieurRepo extends JpaRepository<Skieur,Long> {
    @Query("select s from  Skieur s where s.abonnement=:abonnement")
    List<Skieur> findByType(@Param("abonnement") TypeAbonnement typeAbonnement);
}
