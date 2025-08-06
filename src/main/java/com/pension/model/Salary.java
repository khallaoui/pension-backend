package com.pension.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "salaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private LocalDate date;

    // example relation to Allocataire (if any)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "allocataire_id")
    private Allocataire allocataire;

    // other fields ...
}
