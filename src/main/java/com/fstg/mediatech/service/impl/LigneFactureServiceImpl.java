package com.fstg.mediatech.service.impl;

import com.fstg.mediatech.dao.LigneFactureDao;
import com.fstg.mediatech.models.LigneFactureEntity;
import com.fstg.mediatech.service.facade.LigneFactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LigneFactureServiceImpl implements LigneFactureService {
    private final LigneFactureDao ligneFactureDao;

    @Override
    public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity) {
        return ligneFactureDao.save(ligneFactureEntity);
    }

    @Override
    public List<LigneFactureEntity> findAll() {
        return ligneFactureDao.findAll();
    }
}
