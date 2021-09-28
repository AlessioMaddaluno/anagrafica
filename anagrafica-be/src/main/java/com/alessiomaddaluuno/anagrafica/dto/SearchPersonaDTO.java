package com.alessiomaddaluuno.anagrafica.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchPersonaDTO {

    private String nome;
    private String cognome;
    private Integer etaMin;
    private Integer etaMax;
    private String citta;

    private Integer page;
    private Integer pageSize;

    private String sortBy;
    private String sortDirection;

}
