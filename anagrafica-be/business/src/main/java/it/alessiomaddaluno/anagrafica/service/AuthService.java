package it.alessiomaddaluno.anagrafica.service;


import com.auth0.jwt.interfaces.DecodedJWT;
import it.alessiomaddaluno.anagrafica.dto.SignUpDTO;
import it.alessiomaddaluno.anagrafica.exception.AnagraficaException;
import it.alessiomaddaluno.anagrafica.model.Utente;
import it.alessiomaddaluno.anagrafica.repository.UtenteRepository;
import it.alessiomaddaluno.anagrafica.resource.UtenteResource;
import it.alessiomaddaluno.anagrafica.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUser(String username, String password) {

        String encodedPassword = password;
        Utente utente = this.utenteRepository.findByUsernameAndPassword(username, encodedPassword);

        if (utente == null) {
            throw new AnagraficaException("Username e/o password errati", HttpStatus.UNAUTHORIZED);
        }

        Map<String, String> claimMap = new HashMap<>();
        claimMap.put("user", utente.getUsername());
        String jwt = JwtProvider.createJwt(utente.getUsername(), claimMap);

        return jwt;
    }

    public String registerUser(SignUpDTO dto) {

        Utente utente = this.utenteRepository.findByUsername(dto.getUsername());

        if (utente != null) {
            throw new AnagraficaException("Username non disponibile", HttpStatus.UNAUTHORIZED);
        }

        String encodedPassword = dto.getPassword();

        Utente nuovoUtente = new Utente();
        nuovoUtente.setUsername(dto.getUsername());
        nuovoUtente.setPassword(encodedPassword);

        utenteRepository.save(nuovoUtente);

        String jwt = this.authenticateUser(dto.getUsername(), dto.getPassword());

        return jwt;

    }

    public UtenteResource getMe(String token) {

        DecodedJWT decodedJWT = JwtProvider.verifyJwt(token);
        String username = decodedJWT.getClaim("user").as(String.class);
        Utente utente = this.utenteRepository.findByUsername(username);

        UtenteResource resource = new UtenteResource();
        resource.setUsername(utente.getUsername());

        return resource;

    }

}
