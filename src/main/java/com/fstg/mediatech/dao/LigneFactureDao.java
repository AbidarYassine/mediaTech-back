package com.fstg.mediatech.dao;

import com.fstg.mediatech.models.LigneFactureEntity;
import com.fstg.mediatech.models.LigneFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity, LigneFactureKey> {
}
