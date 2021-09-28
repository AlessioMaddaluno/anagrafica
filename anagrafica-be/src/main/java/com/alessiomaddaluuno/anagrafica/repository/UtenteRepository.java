package com.alessiomaddaluuno.anagrafica.repository;


import com.alessiomaddaluuno.anagrafica.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente,String> {

    Utente findByUsernameAndPassword(String username, String password);

    Utente findByUsername(String username);
}
