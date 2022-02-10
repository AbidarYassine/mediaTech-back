package com.fstg.mediatech.service.facade;

import com.fstg.mediatech.models.LigneFactureEntity;

import java.util.List;

public interface LigneFactureService {

    LigneFactureEntity save(LigneFactureEntity ligneFactureEntity);

    List<LigneFactureEntity> findAll();
}
