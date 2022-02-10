package com.fstg.mediatech.dao;

import com.fstg.mediatech.models.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProduitDao extends JpaRepository<ProduitEntity, Integer> {

    Optional<ProduitEntity> findByRef(String ref);

    Optional<ProduitEntity> findByLibelle(String libelle);

    List<ProduitEntity> findByPrixGreaterThan(BigDecimal value);

    int deleteByRef(String ref);
}