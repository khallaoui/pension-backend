package com.pension.repository;

import com.pension.model.Pensioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface PensionerRepository extends JpaRepository<Pensioner, Long> {
    
    // Find pensioners by city
    List<Pensioner> findByCity(String city);
    
    // Find pensioners by payment method
    List<Pensioner> findByPaymentMethod(Pensioner.PaymentMethod paymentMethod);
    
    // Count pensioners by city for dashboard
    @Query("SELECT p.city, COUNT(p) FROM Pensioner p GROUP BY p.city")
    List<Object[]> countPensionersByCity();
    
    // Count pensioners by payment method
    @Query("SELECT p.paymentMethod, COUNT(p) FROM Pensioner p GROUP BY p.paymentMethod")
    List<Object[]> countPensionersByPaymentMethod();
}
package com.pension.repository;

import com.pension.model.Pensioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface PensionerRepository extends JpaRepository<Pensioner, Long> {

    // Find pensioners by city
    List<Pensioner> findByCity(String city);

    // Find pensioners by payment method
    List<Pensioner> findByPaymentMethod(Pensioner.PaymentMethod paymentMethod);

    // Count pensioners by city for dashboard
    @Query("SELECT p.city, COUNT(p) FROM Pensioner p GROUP BY p.city")
    List<Object[]> countPensionersByCity();

    // Count pensioners by payment method
    @Query("SELECT p.paymentMethod, COUNT(p) FROM Pensioner p GROUP BY p.paymentMethod")
    List<Object[]> countPensionersByPaymentMethod();
}