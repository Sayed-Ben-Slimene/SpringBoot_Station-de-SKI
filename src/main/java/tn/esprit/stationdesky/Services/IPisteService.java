package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.entities.Piste;
import tn.esprit.stationdesky.entities.Skieur;

import java.util.List;

public interface IPisteService {
    Piste add(Piste piste);
    Piste update(Piste piste );
    void remove (long numPiste);
    List<Piste> getAllPiste();
    Piste getPiste(long numPiste);

}
