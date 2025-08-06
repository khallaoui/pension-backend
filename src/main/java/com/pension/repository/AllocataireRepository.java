
package com.pension.repository;

import com.pension.model.Adherent;
import com.pension.model.Allocataire;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AllocataireRepository extends JpaRepository<Allocataire, Long> {
}