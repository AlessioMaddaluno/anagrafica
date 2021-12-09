package it.alessiomaddaluno.anagrafica.resource;

public class TokenResource {

    private String token;

    public TokenResource(String token) {
        this.token = token;
    }

    public TokenResource() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
