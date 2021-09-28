package com.alessiomaddaluuno.anagrafica.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class PersonaDTO {
    private String nome;
    private String cognome;
    private Integer eta;
    private String citta;
}
