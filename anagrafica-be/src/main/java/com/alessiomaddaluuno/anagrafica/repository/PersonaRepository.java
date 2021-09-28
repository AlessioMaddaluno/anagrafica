package com.alessiomaddaluuno.anagrafica.repository;

import com.alessiomaddaluuno.anagrafica.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
}
