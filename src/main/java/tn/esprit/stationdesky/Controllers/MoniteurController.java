package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Respository.MoniteurRepo;
import tn.esprit.stationdesky.Services.IMoniteurService;
import tn.esprit.stationdesky.entities.Cours;
import tn.esprit.stationdesky.entities.Moniteur;

import java.util.List;
@Tag(name = "MoniteurController Management")
@AllArgsConstructor
@RequestMapping("/moniteur")
@RestController
public class MoniteurController {

    IMoniteurService moniteurService;

    @PostMapping("/add-moniteur")
    void addMoniteur(@RequestBody Moniteur moniteur){
        moniteurService.addMoniteur(moniteur);
    }
    @PutMapping("/update-moniteur")
    void updateMoniteur(@RequestBody Moniteur moniteur){
        moniteurService.updateMoniteur(moniteur);
    }
    @GetMapping("/retrive-moniteur/{id}")
    Moniteur getMoniteur(@PathVariable Long id){
        return moniteurService.retreiveMoniteur(id);
    }
    @DeleteMapping("/remove-moniteur/{id}")
    void deleteMoniteur(@PathVariable Long id){
        moniteurService.deleteMoniteur(id);
    }
    @GetMapping("/get-moniteur")
    List<Moniteur> getCourss(){
        return moniteurService.retreiveMoniteurs();
    }


    @PostMapping("/addInstructorAndAssignToCourse")
    Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur  moniteur ,@RequestParam Long numCourse){
        return moniteurService.addInstructorAndAssignToCourse (moniteur, numCourse);
    }
}
