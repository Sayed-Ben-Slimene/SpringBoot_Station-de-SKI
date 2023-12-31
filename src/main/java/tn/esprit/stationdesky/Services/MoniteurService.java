package tn.esprit.stationdesky.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stationdesky.Respository.CoursRepo;
import tn.esprit.stationdesky.Respository.MoniteurRepo;
import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Moniteur;
import tn.esprit.stationdesky.entities.Support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class MoniteurService implements IMoniteurService{
    CoursRepo coursRepo;

    MoniteurRepo moniteurRepo;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur retreiveMoniteur(long id) {
        return moniteurRepo.findById(id).orElseThrow(() ->new NullPointerException("invalid id "+id));
    }

    @Override
    public void deleteMoniteur(long id) {
        moniteurRepo.deleteById(id);

    }

    @Override
    public List<Moniteur> retreiveMoniteurs() {

            return moniteurRepo.findAll();
        }

    @Override
    public Moniteur addInstructorAndAssignToCourse (Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepo.findById(numCourse).get();
        if (moniteur.getCours() == null) {
            moniteur.setCours(new HashSet<> ());
        }
        moniteur.getCours().add(cours);
        return moniteurRepo.save(moniteur);
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport (Long numInstructor, Support support) {
        Moniteur m=moniteurRepo.findById(numInstructor).orElseThrow(null);
        return null;
    }

}
