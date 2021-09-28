package com.alessiomaddaluuno.anagrafica.resource;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class PersonaResource {
    private Long id;
    private String nome;
    private String cognome;
    private Integer eta;
    private String citta;
}
