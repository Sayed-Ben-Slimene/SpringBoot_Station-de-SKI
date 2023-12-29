package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.entities.Inscription;
import tn.esprit.stationdesky.Services.IInscription;
import tn.esprit.stationdesky.Services.InsciptionService;
import tn.esprit.stationdesky.entities.Skieur;

import java.util.List;
@Tag(name = "insciption Management")
@AllArgsConstructor
@RequestMapping("/insciption")
@RestController
public class InscriptionController {

    IInscription iInscription;

    @PostMapping("/add-insciption/add")
    Inscription add(@RequestBody Inscription insciption){
        return iInscription.add(insciption);
    }
    @GetMapping("/retriveAll-Insciption")
    List<Inscription> getInsciptions(){
        return iInscription.getAllInscription();
    }
    @PutMapping("/update-insciption")
    Inscription updateInsciption(@RequestBody Inscription insciption){
        return iInscription.update(insciption);
    }
    @DeleteMapping("/delete-insciption/{id}")
    void deleteInsciption(@PathVariable long id){iInscription.remove(id);}
    @GetMapping("/get-insciption/{id}")
    Inscription getInsciption(@PathVariable long id){
        return iInscription.getInscription(id);
    }

    @PostMapping("/addRegistrationAndAssignToSkier")
     Inscription addRegistrationAndAssignToSkier(@RequestBody Inscription registration ,@RequestParam Long skier){
        iInscription.addRegistrationAndAssignToSkier (registration,skier);
        return registration;
    }

    @PostMapping("/assignRegistrationToCourse")
    Inscription assignRegistrationToCourse(@RequestParam Long numRegistration ,@RequestParam Long numCours ){
      return iInscription.assignRegistrationToCourse (numRegistration,numCours);

    }


    @PostMapping("/addRegistrationAndAssignToSkierAndCourse")
    Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription registration, @RequestParam Long numSkieur ,@RequestParam Long numCours ){
        return iInscription.addRegistrationAndAssignToSkierAndCourse (registration,numSkieur,numCours);

    }



}
