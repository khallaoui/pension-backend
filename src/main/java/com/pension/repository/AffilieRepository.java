package com.pension.repository;

import com.pension.model.Affilie;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AffilieRepository extends JpaRepository<Affilie, Long> {
    List<Affilie> findByActifTrueOrAyantDroitTrue();
}