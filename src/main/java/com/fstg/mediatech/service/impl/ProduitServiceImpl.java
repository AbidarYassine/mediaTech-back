package com.fstg.mediatech.service.impl;

import com.fstg.mediatech.dao.ProduitDao;
import com.fstg.mediatech.dto.ProduitDto;
import com.fstg.mediatech.models.ProduitEntity;
import com.fstg.mediatech.service.facade.ProduitService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitDao produitDao;
    private final ModelMapper modelMapper;

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        if (findByRef(produitDto.getRef()) != null) return null;
        ProduitEntity produitEntity = modelMapper.map(produitDto, ProduitEntity.class);
        ProduitEntity savedProduit = produitDao.save(produitEntity);
        return modelMapper.map(savedProduit, ProduitDto.class);
    }

    @Transactional
    @Override
    public int delete(String ref) {
        return produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {
        Optional<ProduitEntity> produitEntity = produitDao.findByRef(produitDto.getRef());
        if (produitEntity.isEmpty()) return null;
        update(produitEntity.get(), produitDto);
        ProduitEntity saved = produitDao.save(produitEntity.get());
        return modelMapper.map(saved, ProduitDto.class);
    }

    private void update(ProduitEntity produitEntity, ProduitDto produitDto) {
        produitEntity.setLibelle(produitDto.getLibelle());
        produitEntity.setPrix(produitDto.getPrix());
        produitEntity.setQuantiteStock(produitDto.getQuantiteStock());
    }

    @Override
    public ProduitDto findByRef(String ref) {
        ProduitEntity produitEntity = produitDao.findByRef(ref).orElse(null);
        if (produitEntity == null) return null;
        return modelMapper.map(produitEntity, ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findAll() {
        return produitDao.findAll().stream().map(el -> modelMapper.map(el, ProduitDto.class)).collect(Collectors.toList());
    }
}
