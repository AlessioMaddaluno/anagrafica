package it.alessiomaddaluno.anagrafica.repository;


import it.alessiomaddaluno.anagrafica.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
