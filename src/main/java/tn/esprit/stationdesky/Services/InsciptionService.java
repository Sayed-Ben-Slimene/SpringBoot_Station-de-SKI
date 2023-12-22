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
    @Autowired
    InscriptionRepo InscriptionRepo;
    @Autowired
    SkieurRepo SkieurRepo;
    @Autowired
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
        return InscriptionRepo.findAll();
    }

    @Override
    public Inscription getInscription(long numInscription) {
        return InscriptionRepo.findById(numInscription).orElseThrow(()-> new NullPointerException("Invalid"));
    }

    @Override
    public Inscription addRegistrationAndAssignToSkier (Inscription inscription, Long numSkier) {
        Skieur skieur = SkieurRepo.findById(numSkier).orElse(null);
        inscription.setSkieur(skieur);
        return InscriptionRepo.save(inscription);
    }

    @Override
    public Inscription assignRegistrationToCourse (Long numRegistration, Long numCours) {
        Cours cour =coursRepository.findById(numCours).orElseThrow(null);
        Inscription inscri= InscriptionRepo.findById(numRegistration).orElseThrow();
        inscri.setCours(cour);
        return InscriptionRepo.save(inscri);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse (Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur = SkieurRepo.findById(numSkieur).orElseThrow(() -> new NullPointerException("Skieur non trouvé avec le numéro : " + numSkieur));
        Cours cours = coursRepository.findById(numCours).orElseThrow(() -> new NullPointerException("Cours non trouvé avec le numéro : " + numCours));
            //verifi type cours et nb inscri
            if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT || cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE) {
                // Vérifier si nb inscri ne dépasse pas 6
                List<Inscription> inscriptionsForCourse = InscriptionRepo.findByCours(cours);
                if (inscriptionsForCourse.size() >= 6) {
                    throw new RuntimeException("Le nombre maximal d'inscriptions pour ce cours a été atteint.");
                }
            }
/*    if (cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT && ageSkieur >= 18) {
       throw new RuntimeException("Le skieur est trop vieux pour ce cours collectif enfant.");
    }*/
        inscription.setSkieur(skieur);
        inscription.setCours(cours);
        return InscriptionRepo.save(inscription);
    }
}
