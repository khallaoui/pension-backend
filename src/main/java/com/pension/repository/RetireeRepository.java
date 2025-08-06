package com.pension.repository;

import com.pension.model.Adherent;
import com.pension.model.Retiree;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RetireeRepository extends JpaRepository<Retiree, Long> {
    List<Retiree> findByRembourseTrue();
}	
