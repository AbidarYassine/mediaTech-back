package com.fstg.mediatech.service.facade;

import com.fstg.mediatech.dto.ProduitDto;

import java.util.List;

public interface ProduitService {

    ProduitDto save(ProduitDto produitDto);

    int delete(String ref);

    ProduitDto update(ProduitDto produitDto);

    ProduitDto findByRef(String ref);

    List<ProduitDto> findAll();

}
