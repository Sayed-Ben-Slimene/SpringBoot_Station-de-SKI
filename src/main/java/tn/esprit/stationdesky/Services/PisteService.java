package tn.esprit.stationdesky.Services;

import tn.esprit.stationdesky.Respository.PisteRepo;
import tn.esprit.stationdesky.Respository.SkieurRepo;
import tn.esprit.stationdesky.entities.Piste;
import tn.esprit.stationdesky.entities.Skieur;

import java.util.List;

public class PisteService implements IPisteService {
    PisteRepo pisteRepositroy;
    SkieurRepo skieurRepository;
    public PisteService(PisteRepo pisteRepositroy) {
        this.pisteRepositroy = pisteRepositroy;
    }
    @Override
    public Piste add (Piste piste) {
        return pisteRepositroy.save(piste);
    }

    @Override
    public Piste update (Piste piste) {
        return pisteRepositroy.save(piste) ;
    }

    @Override
    public void remove (long numPiste) {
        pisteRepositroy.deleteById(numPiste);

    }

    @Override
    public List<Piste> getAllPiste () {
        return pisteRepositroy.findAll();
    }

    @Override
    public Piste getPiste (long numPiste) {
        return  pisteRepositroy.findById(numPiste).orElseThrow(()-> new NullPointerException("Invalid"));
    }

    @Override
    public Skieur assignSkierToPiste (Long numSkieur, Long numPiste) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElseThrow(null);
        Piste piste =pisteRepositroy.findById(numPiste).orElseThrow(null);
        piste.getSkieurs().add(skieur);

        return skieurRepository.save(skieur);    }
}
