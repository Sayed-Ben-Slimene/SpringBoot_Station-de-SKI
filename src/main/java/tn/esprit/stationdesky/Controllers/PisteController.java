package tn.esprit.stationdesky.Controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stationdesky.Services.IPisteService;
import tn.esprit.stationdesky.entities.Piste;

import java.util.List;

@Tag(name = "Piste Management")
@AllArgsConstructor
@RequestMapping("/piste")
@RestController
public class PisteController {

    @Autowired
    IPisteService pisteService;

    @PostMapping("/add-piste")
    void addPiste(@RequestBody Piste piste){
         pisteService.add (piste);
    }
    @PutMapping("/update-piste")
    void updatePiste(@RequestBody Piste piste){
        pisteService.update(piste);
    }

    @DeleteMapping("/remove-piste/{id}")
    void deletePiste(@PathParam("id") Long id){

        pisteService.remove (id);
    }
    @GetMapping("/retrive-piste")
    List<Piste> getPistes(){
        return pisteService.getAllPiste ();
    }
}
