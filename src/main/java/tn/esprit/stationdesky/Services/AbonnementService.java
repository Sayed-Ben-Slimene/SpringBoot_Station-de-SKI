package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.Respository.AbonnementRepo;
import tn.esprit.stationdesky.entities.Abonnement;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class AbonnementService implements IAbonnementService{
    AbonnementRepo abonnementRepository;

    public AbonnementService(AbonnementRepo abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public Abonnement add (Abonnement aonnement) {
        return abonnementRepository.save(aonnement);    }

    @Override
    public Abonnement update (Abonnement aonnement) {
        return abonnementRepository.save(aonnement);    }

    @Override
    public void remove (long numAbon) {
        abonnementRepository.deleteById(numAbon);
    }

    @Override
    public List<Abonnement> getAllAonnement () {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement getAonnement (long numAbon) {
        return abonnementRepository.findById(numAbon).orElseThrow(()-> new NullPointerException("Invalid"));
    }

    @Override
    public Set<Abonnement> getSubscriptionByType (TypeAbonnement type) {
        return abonnementRepository.findByType(type);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates (LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findByDates(startDate,endDate);
    }

    @Override
    public void retrieveSubscriptions () {

    }
}
