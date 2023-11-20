package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.entities.Abonnement;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    Abonnement add(Abonnement aonnement);
    Abonnement update(Abonnement aonnement );
    void remove (long numAbon);
    List<Abonnement> getAllAonnement();
    Abonnement getAonnement(long numAbon);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
    void retrieveSubscriptions();
}
