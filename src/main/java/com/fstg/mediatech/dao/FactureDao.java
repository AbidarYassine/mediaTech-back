package com.fstg.mediatech.dao;

import com.fstg.mediatech.models.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<FactureEntity, Integer> {
}
