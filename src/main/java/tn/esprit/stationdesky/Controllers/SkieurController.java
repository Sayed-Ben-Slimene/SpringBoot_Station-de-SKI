package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.ISkieurService;
import tn.esprit.stationdesky.Services.SkieurService;
import tn.esprit.stationdesky.entities.Skieur;
import java.util.List;
@Tag(name = "Skieur Management")
@AllArgsConstructor
@RequestMapping("/skieur")
@RestController
public class SkieurController {

    @Autowired
    ISkieurService skieurService;

    @PostMapping("/add-skieur")
    void addSkieur(@RequestBody Skieur skieur){
         skieurService.addSkieur(skieur);
    }
    @PutMapping("/update-skieur")
    void updateSkieur(@RequestBody Skieur skieur){
        skieurService.updateSkieur(skieur);
    }

    @DeleteMapping("/remove-skieur/{id}")
    void deleteSkieur(@PathParam("id") Long id){

        skieurService.deleteSkieur(id);
    }


    @GetMapping("/retrive-skieur")
    List<Skieur> getSkieurs(){
        return skieurService.retreiveSkieurs();
    }
}
