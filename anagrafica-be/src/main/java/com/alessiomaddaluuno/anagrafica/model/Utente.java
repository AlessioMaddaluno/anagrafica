package com.alessiomaddaluuno.anagrafica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "UTENTE")
@Getter
@Setter
@NoArgsConstructor
public class Utente {

    @Id
    @Column(name = "USERNAME",nullable = false)
    private String username;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

}
