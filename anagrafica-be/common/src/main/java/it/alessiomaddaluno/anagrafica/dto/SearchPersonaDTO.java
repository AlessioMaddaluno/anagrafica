package it.alessiomaddaluno.anagrafica.dto;

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

    public Integer getEtaMin() {
        return etaMin;
    }

    public void setEtaMin(Integer etaMin) {
        this.etaMin = etaMin;
    }

    public Integer getEtaMax() {
        return etaMax;
    }

    public void setEtaMax(Integer etaMax) {
        this.etaMax = etaMax;
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
}
