package com.fstg.mediatech.service.impl;

import com.fstg.mediatech.dao.FactureDao;
import com.fstg.mediatech.models.FactureEntity;
import com.fstg.mediatech.service.facade.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    private final FactureDao factureDao;

    @Override
    public FactureEntity save(FactureEntity factureEntity) {
        return factureDao.save(factureEntity);
    }

    @Override
    public List<FactureEntity> findAll() {
        return factureDao.findAll();
    }
}
