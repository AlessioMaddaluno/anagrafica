package it.alessiomaddaluno.anagrafica.model;

import javax.persistence.*;

@Entity(name = "PERSONA")
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

    public Persona() {
    }

    public Persona(Long id, String nome, String cognome, Integer eta, String citta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.citta = citta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
