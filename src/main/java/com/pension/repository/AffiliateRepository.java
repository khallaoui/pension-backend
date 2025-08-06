package com.pension.repository;

import com.pension.model.Adherent;
import com.pension.model.Affiliate;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AffiliateRepository extends JpaRepository<Affiliate, Long> {
    List<Affiliate> findByActifTrueOrAyantDroitTrue();
}