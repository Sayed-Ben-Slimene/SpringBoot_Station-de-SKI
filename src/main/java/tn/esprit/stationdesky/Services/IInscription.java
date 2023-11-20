package tn.esprit.stationdesky.Services;


import tn.esprit.stationdesky.entities.Inscription;

import java.util.List;

public interface IInscription {
    Inscription add(Inscription inscription);
    Inscription update(Inscription inscription );
    void remove (long numInscription);
    List<Inscription> getAllInscription();
    Inscription getInscription(long numInscription);

    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier);

    Inscription assignRegistrationToCourse(Long numRegistration, Long numCours);
    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
