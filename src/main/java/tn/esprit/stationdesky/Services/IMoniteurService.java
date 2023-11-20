package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.entities.Moniteur;
import tn.esprit.stationdesky.entities.Support;

import java.util.List;

public interface IMoniteurService {
    public Moniteur addMoniteur(Moniteur moniteur);
    public Moniteur updateMoniteur(Moniteur moniteur);
    public Moniteur retreiveMoniteur(long id);
    public void deleteMoniteur(long id);
    List<Moniteur> retreiveMoniteurs();
    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
