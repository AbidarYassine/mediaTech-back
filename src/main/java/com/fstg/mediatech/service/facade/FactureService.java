package com.fstg.mediatech.service.facade;

import com.fstg.mediatech.models.FactureEntity;

import java.util.List;

public interface FactureService {

    FactureEntity save(FactureEntity factureEntity);

    List<FactureEntity> findAll();
}
