package tn.esprit.stationdesky.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stationdesky.Respository.*;
import tn.esprit.stationdesky.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class SkieurService implements ISkieurService{

    SkieurRepo skieurRepo;
    InscriptionRepo inscriptionRepo;
    AbonnementRepo abonnementRepo;
    CoursRepo coursRepo;
    PisteRepo pisteRepo;

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return  skieurRepo.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return  skieurRepo.save(skieur);
    }

    @Override
    public Skieur retreiveSkieur(long id) {
        return skieurRepo.findById(id).orElseThrow(() ->new NullPointerException("invalid id "+id));
    }

    @Override
    public void deleteSkieur(long id) {
        skieurRepo.deleteById (id);
    }

    @Override
    public List<Skieur> retreiveSkieurs() {
        return skieurRepo.findAll();
    }

    @Override
    public Skieur assignSkierToPiste (Long numSkieur, Long numPiste) {
        Skieur skieur =skieurRepo.findById (numSkieur).orElse(null);
        Piste piste =pisteRepo.findById (numPiste).orElse(null);
        if (piste != null && skieur != null) {
            piste.getSkieurs().add (skieur);
            pisteRepo.save(piste);
        }
        return skieurRepo.save (skieur);
    }


    @Override
    public Skieur addSkierAndAssignToCourse (Skieur skier, Long numCours) {
        Cours cours =coursRepo.findById(numCours).orElseThrow (null);
        Set<Inscription> inscriptions =skier.getInscriptions ();
        for ( Inscription inscription :inscriptions){
            inscription.setSkieur (skier);
            inscription.setCours (cours);
            inscriptionRepo.save (inscription);
        }
        return skieurRepo.save (skier);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType (TypeAbonnement typeAbonnement) {
        return skieurRepo.findByAbonnementTypeAbonnement (typeAbonnement);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates (LocalDate startDate, LocalDate endDate) {
        return  abonnementRepo.findByDate(startDate, endDate);
    }
}
