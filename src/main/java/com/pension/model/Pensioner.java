package com.pension.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pensioners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pensioner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyPayment;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private LocalDate lastPaymentDate;

    private LocalDate birthDate;

    private String phoneNumber;

    public enum PaymentMethod {
        BANK_TRANSFER, CHECK, CASH, DIGITAL_WALLET
    }
}
package com.pension.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pensioners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pensioner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyPayment;
    
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    
    private LocalDate lastPaymentDate;
    
    private LocalDate birthDate;
    
    private String phoneNumber;
    
    public enum PaymentMethod {
        BANK_TRANSFER, CHECK, CASH, DIGITAL_WALLET
    }
}