package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.CoursService;
import tn.esprit.stationdesky.Services.ICoursService;
import tn.esprit.stationdesky.entities.Cours;

import java.util.List;
@Tag(name = "cours Management")
@AllArgsConstructor
@RequestMapping("/cours")
@RestController
public class CoursController {

    ICoursService coursService;
    @PostMapping("/add-cours")
    Cours addCours(@RequestBody Cours cours){
        return coursService.addCours(cours);
    }


    @GetMapping("/get-cours/{id}")
    Cours getCours(@PathVariable long id){
        return coursService.retreiveCours(id);
    }

    @DeleteMapping("/remove-cours/{id}")
    void deleteCours(@PathVariable long id) {
        coursService.deleteCours(id);
    }
    @PutMapping("/update-coursUpdate")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }
}
