package tn.esprit.stationdesky.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.CoursService;
import tn.esprit.stationdesky.Services.ICoursService;
import tn.esprit.stationdesky.entities.Cours;

import java.util.List;
@AllArgsConstructor
@RestController
public class CoursController {
ICoursService coursService;
    @PostMapping("/cours/add")
    Cours addCours(@RequestBody Cours cours){
        return coursService.addCours(cours);
    }


    @GetMapping("/cours/{id}")
    Cours getCours(@PathVariable long id){
        return coursService.retreiveCours(id);
    }
    @GetMapping("/cours")
    List<Cours> getCourss(){
        return coursService.retreiveCourss();
    }
    @DeleteMapping("/cours/{id}")
    void deleteCours(@PathVariable long id) {
        coursService.deleteCours(id);
    }
    @PutMapping("/coursUpdate")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }
}
