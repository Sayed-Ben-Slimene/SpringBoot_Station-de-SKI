package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.entities.Abonnement;
import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Skieur;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface ISkieurService {
    public Skieur addSkieur(Skieur skieur);
    public Skieur updateSkieur(Skieur skieur);
    public Skieur retreiveSkieur(long id);
    public void deleteSkieur(long id);
    List<Skieur> retreiveSkieurs();
    Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate,LocalDate endDate);

}
