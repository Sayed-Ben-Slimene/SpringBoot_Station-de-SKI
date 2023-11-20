package tn.esprit.stationdesky.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.IMoniteurService;
import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Moniteur;

import java.util.List;
@AllArgsConstructor
@RestController
public class MoniteurController {
    IMoniteurService moniteurService;



    @PostMapping("/moniteur")
    void addMoniteur(@RequestBody Moniteur moniteur){
        moniteurService.addMoniteur(moniteur);
    }
    @PutMapping("/moniteur")
    void updateMoniteur(@RequestBody Moniteur moniteur){
        moniteurService.updateMoniteur(moniteur);
    }
    @GetMapping("/moniteur/{id}")
    Moniteur getMoniteur(@PathVariable Long id){
        return moniteurService.retreiveMoniteur(id);
    }
    @DeleteMapping("/moniteur/{id}")
    void deleteMoniteur(@PathVariable Long id){
        moniteurService.deleteMoniteur(id);
    }
    @GetMapping("/moniteur")
    List<Moniteur> getCourss(){
        return moniteurService.retreiveMoniteurs();
    }
}
