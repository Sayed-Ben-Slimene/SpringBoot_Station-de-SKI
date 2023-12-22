package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.IAbonnementService;
import tn.esprit.stationdesky.entities.Abonnement;

import java.util.List;

@Tag(name = "Abonnement Management")
@AllArgsConstructor
@RequestMapping("/abonnement")
@RestController
public class AbonnementController {

    @Autowired
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
}
