package tn.esprit.stationdesky.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.stationdesky.Respository.CoursRepo;
import tn.esprit.stationdesky.Respository.MoniteurRepo;
import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Moniteur;

import java.util.List;

@AllArgsConstructor
@Service
public class CoursService implements ICoursService{


    CoursRepo coursRepo;

    @Override
    public Cours addCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours retreiveCours(long id) {
        return coursRepo.findById(id).orElseThrow(() ->new NullPointerException("invalid id "+id));
    }

    @Override
    public void deleteCours(long id) {
        coursRepo.deleteById(id);
    }

    @Override
    public List<Cours> retreiveCourss() {
        return coursRepo.findAll();
    }

    @Override
    public Cours getCours (long numCours) {
        return coursRepo.findById(numCours).orElseThrow(()-> new NullPointerException("Invalid"));
    }
}
