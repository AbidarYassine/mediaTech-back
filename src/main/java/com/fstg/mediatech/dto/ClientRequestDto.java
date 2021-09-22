package com.fstg.mediatech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {


    @NotBlank(message = "Ce Champ est obligatoire !!")
    @Size(min = 5, message = "ce champ doit avoir au moins 5 charactere")
    @Size(max = 20, message = "ce champs ne doit pas depasser 20 charactere")
    private String nom;


    @NotBlank(message = "Ce Champ est obligatoire !!")
    @Size(min = 5, message = "ce champ doit avoir au moins 5 character")
    @Size(max = 20, message = "ce champs ne doit pas depasser 20 charactere")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$", message = "format invalid")
    private String telephone;


}
