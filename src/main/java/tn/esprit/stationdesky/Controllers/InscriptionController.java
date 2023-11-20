package tn.esprit.stationdesky.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.entities.Inscription;
import tn.esprit.stationdesky.Services.IInscription;
import tn.esprit.stationdesky.Services.InsciptionService;

import java.util.List;

@RestController

public class InscriptionController {
    IInscription iInscription;

    public InscriptionController(IInscription iInscription) {
        this.iInscription = iInscription;
    }

    @PostMapping("/insciption/add")
    Inscription add(@RequestBody Inscription insciption){
        return iInscription.add(insciption);
    }
    @GetMapping("/insciption/allInsciption")
    List<Inscription> getInsciptions(){
        return iInscription.getAllInscription();
    }
    @PutMapping("/insciption/update")
    Inscription updateInsciption(@RequestBody Inscription insciption){return iInscription.update(insciption);}
    @DeleteMapping("/insciption/delete/{id}")
    void deleteInsciption(@PathVariable long id){iInscription.remove(id);}
    @GetMapping("/insciption/getInsciption/{id}")
    Inscription getInsciption(@PathVariable long id){
        return iInscription.getInscription(id);
    }




}
