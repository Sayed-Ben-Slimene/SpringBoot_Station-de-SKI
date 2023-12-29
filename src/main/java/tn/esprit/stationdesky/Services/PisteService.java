package tn.esprit.stationdesky.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stationdesky.Respository.PisteRepo;
import tn.esprit.stationdesky.Respository.SkieurRepo;
import tn.esprit.stationdesky.entities.Piste;
import tn.esprit.stationdesky.entities.Skieur;

import java.util.List;
@AllArgsConstructor
@Service
public class PisteService implements IPisteService {
    @Autowired
    PisteRepo pisteRepositroy;
    @Autowired
    SkieurRepo skieurRepository;

    @Override
    public Piste add (Piste piste) {
        return pisteRepositroy.save (piste);
    }

    @Override
    public Piste update (Piste piste) {
        return pisteRepositroy.save (piste);
    }

    @Override
    public void remove (long numPiste) {
        pisteRepositroy.deleteById (numPiste);

    }

    @Override
    public List<Piste> getAllPiste () {
        return pisteRepositroy.findAll ();
    }

    @Override
    public Piste getPiste (long numPiste) {
        return pisteRepositroy.findById (numPiste).orElseThrow (() -> new NullPointerException ("Invalid"));
    }
}