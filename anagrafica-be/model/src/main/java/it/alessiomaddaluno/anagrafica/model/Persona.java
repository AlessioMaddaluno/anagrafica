package it.alessiomaddaluno.anagrafica.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "PERSONA")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "COGNOME", nullable = false)
    private String cognome;

    @Column(name = "DATA_NASCITA", nullable = false)
    private LocalDateTime dataNascita;

    @Column(name = "CITTA", nullable = false)
    private String citta;

    public Persona() {
    }

    public Persona(Long id, String nome, String cognome, LocalDateTime dataNascita, String citta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
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

    public LocalDateTime getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDateTime dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
