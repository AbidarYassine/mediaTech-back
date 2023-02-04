package com.fstg.mediatech.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author yassineabidar on 26/1/2023
 */
@Getter
@Setter
public class FactureDto {

    private String ref;
    private String cin;

    List<LigneFactureDto> ligneFactureDtoList;
}
