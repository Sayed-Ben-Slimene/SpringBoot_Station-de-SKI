package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.stationdesky.entities.Skieur;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.util.List;
@Repository
public interface SkieurRepo extends JpaRepository<Skieur,Long> {

/*
    List<Skieur> findByAbonnementTypeAbonnement(TypeAbonnement typeAbonnement);
*/
    @Query("SELECT s FROM Skieur s WHERE s.abonnement.typeAbonnement = :typeAbonnement")

    List<Skieur> findByAbonnementTypeAbonnement(@Param("typeAbonnement")TypeAbonnement typeAbonnement);

}
