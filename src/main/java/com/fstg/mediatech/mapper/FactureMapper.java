package com.fstg.mediatech.mapper;

import com.fstg.mediatech.dao.ClientDao;
import com.fstg.mediatech.dto.FactureDto;
import com.fstg.mediatech.models.ClientEntity;
import com.fstg.mediatech.models.FactureEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**=
 * @author yassineabidar on 26/1/2023
 */
@Component
@RequiredArgsConstructor
public class FactureMapper {

    private final ClientDao clientDao;
    private final LigneFactureMapper ligneFactureMapper;


    public FactureDto toDto(FactureEntity factureEntity) {
        FactureDto factureDto = new FactureDto();
        factureDto.setRef(factureEntity.getRef());
        factureDto.setCin(factureEntity.getClient().getCin());
        factureDto.setLigneFactureDtoList(ligneFactureMapper.toDto(factureEntity.getLigneFactures()));
        return factureDto;
    }

    public FactureEntity toEntity(FactureDto factureDto) {
        FactureEntity factureEntity = new FactureEntity();
        factureEntity.setRef(factureDto.getRef());
        factureEntity.setClient(getClient(factureDto.getCin()));
        factureEntity.setLigneFactures(ligneFactureMapper.toEntities(factureDto.getLigneFactureDtoList()));
        return factureEntity;

    }

    public List<FactureDto> toDto(List<FactureEntity> facturesEntity) {
        return facturesEntity.stream().map(this::toDto).toList();
    }

    public List<FactureEntity> toEntities(List<FactureDto> factureDtos) {
        return factureDtos.stream().map(this::toEntity).toList();
    }

    private ClientEntity getClient(String cin) {
        final var byCin = clientDao.findByCin(cin);
        if (byCin.isEmpty()) {
            throw new RuntimeException("Client not found");
        }
        return byCin.get();
    }
}
