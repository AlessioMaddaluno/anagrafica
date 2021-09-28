package com.alessiomaddaluuno.anagrafica.service;

import com.alessiomaddaluuno.anagrafica.dto.PersonaDTO;
import com.alessiomaddaluuno.anagrafica.dto.SearchPersonaDTO;
import com.alessiomaddaluuno.anagrafica.exception.AnagraficaException;
import com.alessiomaddaluuno.anagrafica.model.Persona;
import com.alessiomaddaluuno.anagrafica.repository.PersonaCustomRepository;
import com.alessiomaddaluuno.anagrafica.repository.PersonaRepository;
import com.alessiomaddaluuno.anagrafica.resource.PersonaResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaCustomRepository personaCustomRepository;

    public PersonaResource findById(Long id){
        Optional<Persona> personaOptional = this.personaRepository.findById(id);

        if(!personaOptional.isPresent()){
            throw new AnagraficaException("Persona con id="+id+" non trovata.", HttpStatus.NOT_FOUND);
        }

        return this.assembler(personaOptional.get());
    }

    public PersonaResource insert(PersonaDTO dto){
        Persona model = personaRepository.save(this.transformer(dto));
        return this.assembler(model);
    }

    public void delete(Long id){
        try{
            personaRepository.deleteById(id);
        }catch (Exception e){
            throw new AnagraficaException("Persona con id="+id+" non trovata.", HttpStatus.NOT_FOUND);
        }
    }

    public PersonaResource update(PersonaDTO dto, Long id){
        Persona model = this.transformer(dto);
        Optional<Persona> personaOptional = this.personaRepository.findById(id);

        if(!personaOptional.isPresent()){
            throw new AnagraficaException("Persona con id="+id+" non trovata.", HttpStatus.NOT_FOUND);
        }

        Persona persona = this.transformer(dto);
        persona.setId(id);

        Persona savedModel = this.personaRepository.save(persona);

        return this.assembler(savedModel);
    }

    public Page<PersonaResource> search(SearchPersonaDTO dto){
        Page<PersonaResource> page = this.personaCustomRepository.search(dto);
        return page;
    }

    // dto -> model
    private Persona transformer(PersonaDTO dto){
        Persona model = new Persona();
        model.setNome(dto.getNome());
        model.setCognome(dto.getCognome());
        model.setEta(dto.getEta());
        model.setCitta(dto.getCitta());
        return model;
    }

    // model -> resource
    private PersonaResource assembler(Persona model){
        return PersonaResource.builder()
                .id(model.getId())
                .nome(model.getNome())
                .cognome(model.getCognome())
                .eta(model.getEta())
                .citta(model.getCitta())
                .build();
    }

}
