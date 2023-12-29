package tn.esprit.stationdesky.Services;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stationdesky.Respository.CoursRepo;
import tn.esprit.stationdesky.Respository.InscriptionRepo;
import tn.esprit.stationdesky.Respository.SkieurRepo;

import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Inscription;
import tn.esprit.stationdesky.entities.Skieur;
import tn.esprit.stationdesky.entities.TypeCours;

import java.util.List;
@AllArgsConstructor
@Service
public class InsciptionService implements IInscription{

    InscriptionRepo InscriptionRepo;
    SkieurRepo skieurRepo;
    CoursRepo coursRepository;

    @Override
    public Inscription add(Inscription inscription) {
        return InscriptionRepo.save(inscription);
    }

    @Override
    public Inscription update(Inscription inscription) {
        return InscriptionRepo.save(inscription);
    }

    @Override
    public void remove(long numInscription) {
        InscriptionRepo.deleteById(numInscription);

    }

    @Override
    public List<Inscription> getAllInscription() {
        return InscriptionRepo.findAll ();
    }

    @Override
    public Inscription getInscription(long numInscription) {
        return InscriptionRepo.findById(numInscription).orElseThrow(()-> new NullPointerException("Invalid"));
    }

    @Override
    public Inscription addRegistrationAndAssignToSkier (Inscription registration, Long numSkier) {
             Skieur skier =skieurRepo.findById(numSkier).get ();
             registration.setSkieur (skier);
         return InscriptionRepo.save(registration);
    }

    @Override
    public Inscription assignRegistrationToCourse (Long numRegistration, Long numCours) {
            Cours cour = coursRepository.findById(numCours).get ();
            Inscription registration = InscriptionRepo.findById (numRegistration).get ();
            registration.setCours (cour);
        return InscriptionRepo.save(registration);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse (Inscription registration, Long numSkieur, Long numCours) {
        Skieur skier = skieurRepo.findById(numSkieur).orElse (null);
        Cours cour = coursRepository.findById(numCours).orElse (null);


        registration.setSkieur (skier);
        registration.setCours (cour);
        return InscriptionRepo.save (registration);
    }


}
