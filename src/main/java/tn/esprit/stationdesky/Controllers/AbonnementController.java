package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.IAbonnementService;
import tn.esprit.stationdesky.entities.Abonnement;
import tn.esprit.stationdesky.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Tag(name = "Abonnement Management")
@AllArgsConstructor
@RequestMapping("/abonnement")
@RestController
public class AbonnementController {


    IAbonnementService abonnementService;

    @PostMapping("/add-abonnement")
    void addAbonnement(@RequestBody Abonnement abonnement){
         abonnementService.add (abonnement);
    }
    @PutMapping("/update-abonnement")
    void updateAbonnement(@RequestBody Abonnement abonnement){
        abonnementService.update(abonnement);
    }

    @DeleteMapping("/remove-abonnement/{id}")
    void deleteAbonnement(@PathParam("id") Long id){
        abonnementService.remove (id);
    }

    @GetMapping("/retrive-abonnement")
    List<Abonnement> getAbonnements(){
        return abonnementService.getAllAonnement ();
    }

    @GetMapping("/getSubscriptionByType")
    Set<Abonnement> getSubscriptionByType(@PathParam("type_abonnement") TypeAbonnement type){
        return abonnementService.getSubscriptionByType(type);
    }

    @GetMapping("/retrieveSubscriptionsByDates")
    List<Abonnement> retrieveSubscriptionsByDates(@PathParam("dateDebut") LocalDate dateDebut ,@PathParam("dateFin") LocalDate dateFin){
        return abonnementService.retrieveSubscriptionsByDates (dateDebut, dateFin);
    }


}
