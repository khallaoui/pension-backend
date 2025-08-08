package com.pension.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data // Génère getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Affilie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAffilie;

    private String matricule;
    private String nom;
    private String prenom;

    private boolean actif;
    private boolean ayantDroit;

    @ManyToOne
    @JoinColumn(name = "id_adherent")
    private Adherent adherent;

    @OneToMany(mappedBy = "affilie")
    @JsonManagedReference
    private List<Allocataire> allocataires;
}
