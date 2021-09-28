package com.alessiomaddaluuno.anagrafica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "UTENTE")
public class Utente {

    @Id
    @Column(name = "USERNAME",nullable = false)
    private String username;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
