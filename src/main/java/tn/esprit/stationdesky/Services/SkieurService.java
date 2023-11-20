package tn.esprit.stationdesky.Services;

import org.springframework.stereotype.Service;
import tn.esprit.stationdesky.Respository.AbonnementRepo;
import tn.esprit.stationdesky.Respository.CoursRepo;
import tn.esprit.stationdesky.Respository.InscriptionRepo;
import tn.esprit.stationdesky.Respository.SkieurRepo;
import tn.esprit.stationdesky.entities.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class SkieurService implements ISkieurService{


    SkieurRepo skieurRepo;
    InscriptionRepo inscriptionRepo;
    AbonnementRepo abonnementRepo;
    CoursRepo coursRepo;
    public SkieurService(SkieurRepo skieurRepo) {
        this.skieurRepo = skieurRepo;
    }


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
         skieurRepo.findById(id);
    }

    @Override
    public List<Skieur> retreiveSkieurs() {
        return skieurRepo.findAll();
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
        return  skieurRepo.findByType(typeAbonnement);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates (LocalDate startDate, LocalDate endDate) {
        return  abonnementRepo.findByDates(startDate, endDate);
    }
}
