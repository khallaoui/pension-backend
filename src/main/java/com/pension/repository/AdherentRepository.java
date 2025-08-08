package com.pension.repository;

import com.pension.model.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {

    List<Adherent> findByCity(String city);

    List<Adherent> findByPaymentMethod(Adherent.PaymentMethod paymentMethod);

    @Query("SELECT p.city, COUNT(p) FROM Adherent p GROUP BY p.city")
    List<Object[]> countAdherentsByCity();

    @Query("SELECT p.paymentMethod, COUNT(p) FROM Adherent p GROUP BY p.paymentMethod")
    List<Object[]> countAdherentsByPaymentMethod();
    
    @Query("SELECT p.city, COUNT(p) FROM Adherent p GROUP BY p.city")
    List<Object[]> findAdherentsGroupedByCity();

}
