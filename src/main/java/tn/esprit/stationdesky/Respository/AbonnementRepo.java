package tn.esprit.stationdesky.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stationdesky.entities.Abonnement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.time.LocalDate;
@Repository
public interface AbonnementRepo extends JpaRepository<Abonnement,Long> {

/*
    @Query("select a from Abonnement a where a.typeAbonnement = :typeABO")
    Set<Abonnement> findByType(@Param ("typeABO") TypeAbonnement type);
*/
    Set<Abonnement> findByTypeAbonnement(TypeAbonnement type);


    @Query("select a from Abonnement a where a.dateDebut = :dateDebut and a.dateFin = :dateFin")
    List<Abonnement> findByDate(@Param ("dateDebut") LocalDate dateDebut , @Param("dateFin") LocalDate dateFin);

    List<Abonnement> findByDateDebutAndDateFin(LocalDate dateDebut ,LocalDate dateFin );


}
