package tn.esprit.stationdesky.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long numSkier;
    String nomS;
    String prenomS;
    LocalDate dateNaissance;
    String ville;

    @ManyToMany(mappedBy="skieurs")
    private Set<Piste> pistes;


    @OneToMany(mappedBy="skieur",cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions;

    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement;
    
}
