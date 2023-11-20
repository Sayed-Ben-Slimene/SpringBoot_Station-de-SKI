package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Moniteur;

import java.util.List;

public interface ICoursService {
    public Cours addCours(Cours cours);
    public Cours updateCours(Cours cours);
    public Cours retreiveCours(long id);
    public void deleteCours(long id);
    List<Cours> retreiveCourss();
    Cours getCours(long numCours);

}
