package com.pension.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Prevents Hibernate proxy issues
public class Allocataire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAllocataire;

    private String numeroDossier;
    private String nom;
    private String prenom;

 
    @ManyToOne
    @JoinColumn(name = "id_affilie")
    @JsonIgnore // Completely ignores affilie during serialization
    private Affilie affilie;

    @OneToMany(mappedBy = "allocataire", cascade = CascadeType.ALL)
    @JsonIgnore // Completely ignores salaries during serialization
    private List<Salary> salaries;
}
