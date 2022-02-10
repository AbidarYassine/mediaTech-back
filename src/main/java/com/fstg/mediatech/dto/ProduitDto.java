package com.fstg.mediatech.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProduitDto {

    @NotBlank
    private String ref;
    @NotBlank
    private String libelle;
    @NotNull
    private BigDecimal prix;
    @NotNull
    private long quantiteStock;
}
