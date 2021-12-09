package it.alessiomaddaluno.anagrafica.service;


import it.alessiomaddaluno.anagrafica.dto.PersonaDTO;
import it.alessiomaddaluno.anagrafica.dto.SearchPersonaDTO;
import it.alessiomaddaluno.anagrafica.exception.AnagraficaException;
import it.alessiomaddaluno.anagrafica.model.Persona;
import it.alessiomaddaluno.anagrafica.repository.PersonaCustomRepository;
import it.alessiomaddaluno.anagrafica.repository.PersonaRepository;
import it.alessiomaddaluno.anagrafica.resource.PersonaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaCustomRepository personaCustomRepository;

    public PersonaResource findById(Long id) {
        Optional<Persona> personaOptional = this.personaRepository.findById(id);

        if (!personaOptional.isPresent()) {
            throw new AnagraficaException("Persona con id=" + id + " non trovata.", HttpStatus.NOT_FOUND);
        }

        return this.assembler(personaOptional.get());
    }

    public PersonaResource insert(PersonaDTO dto) {
        Persona model = personaRepository.save(this.transformer(dto));
        return this.assembler(model);
    }

    public void delete(Long id) {
        try {
            personaRepository.deleteById(id);
        } catch (Exception e) {
            throw new AnagraficaException("Persona con id=" + id + " non trovata.", HttpStatus.NOT_FOUND);
        }
    }

    public PersonaResource update(PersonaDTO dto, Long id) {
        Persona model = this.transformer(dto);
        Optional<Persona> personaOptional = this.personaRepository.findById(id);

        if (!personaOptional.isPresent()) {
            throw new AnagraficaException("Persona con id=" + id + " non trovata.", HttpStatus.NOT_FOUND);
        }

        Persona persona = this.transformer(dto);
        persona.setId(id);

        Persona savedModel = this.personaRepository.save(persona);

        return this.assembler(savedModel);
    }

    public Page<PersonaResource> search(SearchPersonaDTO dto) {
        Page<PersonaResource> page = this.personaCustomRepository.search(dto);
        return page;
    }

    // it.alessiomaddaluno.anagrafica.dto -> it.alessiomaddaluno.anagrafica.model
    private Persona transformer(PersonaDTO dto) {
        Persona model = new Persona();
        model.setNome(dto.getNome());
        model.setCognome(dto.getCognome());
        model.setDataNascita(dto.getDataNascita());
        model.setCitta(dto.getCitta());
        return model;
    }

    // it.alessiomaddaluno.anagrafica.model -> it.alessiomaddaluno.anagrafica.resource
    private PersonaResource assembler(Persona model) {

        PersonaResource resource = new PersonaResource();
        resource.setId(model.getId());
        resource.setNome(model.getNome());
        resource.setCognome(model.getCognome());
        resource.setDataNascita(model.getDataNascita());
        resource.setCitta(model.getCitta());

        return resource;
    }

}
