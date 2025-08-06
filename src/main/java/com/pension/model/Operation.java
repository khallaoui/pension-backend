package com.pension.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pensioner_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pensioner pensioner;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)
    private OperationType type;
    
    @Column(nullable = false)
    private LocalDateTime timestamp;
    
    private String description;
    
    public enum OperationType {
        PAYMENT, ADJUSTMENT, BONUS, DEDUCTION
    }
}