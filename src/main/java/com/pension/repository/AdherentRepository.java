package com.pension.repository;

import com.pension.model.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdherentRepository extends JpaRepository<Adherent, Long> {
    List<Adherent> findByStatut(String statut);
}