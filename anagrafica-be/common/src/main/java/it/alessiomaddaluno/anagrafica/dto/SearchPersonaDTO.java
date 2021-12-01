package it.alessiomaddaluno.anagrafica.dto;

import java.time.LocalDateTime;

public class SearchPersonaDTO {

    private String nome;
    private String cognome;
    private LocalDateTime dataNascitaMin;
    private LocalDateTime dataNascitaMax;
    private String citta;

    private Integer page;
    private Integer pageSize;

    private String sortBy;
    private String sortDirection;

    public SearchPersonaDTO() {
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

    public LocalDateTime getDataNascitaMin() {
        return dataNascitaMin;
    }

    public void setDataNascitaMin(LocalDateTime dataNascitaMin) {
        this.dataNascitaMin = dataNascitaMin;
    }

    public LocalDateTime getDataNascitaMax() {
        return dataNascitaMax;
    }

    public void setDataNascitaMax(LocalDateTime dataNascitaMax) {
        this.dataNascitaMax = dataNascitaMax;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    @Override
    public String toString() {
        return "SearchPersonaDTO{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascitaMin=" + dataNascitaMin +
                ", dataNascitaMax=" + dataNascitaMax +
                ", citta='" + citta + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", sortBy='" + sortBy + '\'' +
                ", sortDirection='" + sortDirection + '\'' +
                '}';
    }
}
