package com.alessiomaddaluuno.anagrafica.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "PERSONA")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "COGNOME",nullable = false)
    private String cognome;

    @Column(name = "ETA",nullable = false)
    private Integer eta;

    @Column(name = "CITTA",nullable = false)
    private String citta;


}
