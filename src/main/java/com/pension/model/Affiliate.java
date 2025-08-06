package com.pension.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Table(name = "affiliates")
@Data @NoArgsConstructor @AllArgsConstructor
public class Affiliate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean actif;
    private boolean ayantDroit;
}