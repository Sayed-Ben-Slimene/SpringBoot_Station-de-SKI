package tn.esprit.stationdesky.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.SkieurService;
import tn.esprit.stationdesky.entities.Skieur;
import java.util.List;
@AllArgsConstructor
@RestController
public class SkieurController {
    SkieurService skieurService;



    @PostMapping("/skieur")
    void addSkieur(@RequestBody Skieur skieur){
        skieurService.addSkieur(skieur);
    }
    @PutMapping("/skieur")
    void updateSkieur(@RequestBody Skieur skieur){
        skieurService.updateSkieur(skieur);
    }
    @GetMapping("/skieur/{id}")
    Skieur getSkieur(@PathVariable Long id){
        return skieurService.retreiveSkieur(id);
    }
    @DeleteMapping("/skieur/{id}")
    void deleteSkieur(@PathVariable Long id){
        skieurService.deleteSkieur(id);
    }
    @GetMapping("/skieur")
    List<Skieur> getSkieurs(){
        return skieurService.retreiveSkieurs();
    }
}
