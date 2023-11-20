package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.stationdesky.entities.Abonnement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;
import java.time.LocalDate;

public interface AbonnementRepo extends JpaRepository<Abonnement,Long> {
    @Query("select a from Abonnement a where a.typeAbonnement=:typeabo")
    Set<Abonnement> findByType(@Param("typeabo") TypeAbonnement type);

    @Query("select a from Abonnement a where a.dateDebut=:startDate and a.dateFin=:endDate ")
    List<Abonnement> findByDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
