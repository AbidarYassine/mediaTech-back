package com.fstg.mediatech.mapper;

import com.fstg.mediatech.dao.ProduitDao;
import com.fstg.mediatech.dto.LigneFactureDto;
import com.fstg.mediatech.models.LigneFactureEntity;
import com.fstg.mediatech.models.ProduitEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yassineabidar on 26/1/2023
 */
@Component
@RequiredArgsConstructor
public class LigneFactureMapper {

    private final ProduitDao produitDao;

    public LigneFactureEntity toEntity(LigneFactureDto ligneFactureDto) {
        LigneFactureEntity ligneFactureEntity = new LigneFactureEntity();
        ligneFactureEntity.setProduit(getProduct(ligneFactureDto.getRefProduit()));
        ligneFactureEntity.setQuantite(ligneFactureDto.getQuantite());
        return ligneFactureEntity;
    }

    public LigneFactureDto toDto(LigneFactureEntity ligneFactureEntity) {
        LigneFactureDto ligneFactureDto = new LigneFactureDto();
        ligneFactureDto.setRefProduit(ligneFactureEntity.getProduit().getRef());
        ligneFactureDto.setQuantite((int) ligneFactureEntity.getQuantite());
        return ligneFactureDto;
    }

    public List<LigneFactureEntity> toEntities(List<LigneFactureDto> ligneFactureDtoList) {
        return ligneFactureDtoList.stream().map(this::toEntity).toList();
    }

    public List<LigneFactureDto> toDto(List<LigneFactureEntity> ligneFactureDtoList) {
        return ligneFactureDtoList.stream().map(this::toDto).toList();
    }

    private ProduitEntity getProduct(String refProduit) {
        final var byRef = produitDao.findByRef(refProduit);
        if (byRef.isEmpty()) {
            throw new RuntimeException("product not found !!");
        }
        return byRef.get();
    }
}
