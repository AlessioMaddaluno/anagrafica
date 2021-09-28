package com.alessiomaddaluuno.anagrafica.controller;

import com.alessiomaddaluuno.anagrafica.dto.PersonaDTO;
import com.alessiomaddaluuno.anagrafica.dto.SearchPersonaDTO;
import com.alessiomaddaluuno.anagrafica.model.Persona;
import com.alessiomaddaluuno.anagrafica.resource.PersonaResource;
import com.alessiomaddaluuno.anagrafica.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // Create
    @PostMapping()
    public ResponseEntity<PersonaResource> insertPersona(@RequestBody PersonaDTO dto){
        PersonaResource resource = this.personaService.insert(dto);
        return ResponseEntity.ok(resource);
    }

    // Read
    @PostMapping("search")
    public ResponseEntity<Page<PersonaResource>> search(@RequestBody SearchPersonaDTO dto){
        Page<PersonaResource> page = this.personaService.search(dto);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResource> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.personaService.findById(id));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Long id){
        this.personaService.delete(id);
        return ResponseEntity.ok(null);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PersonaResource> updatePersona(@PathVariable("id") Long id, @RequestBody() PersonaDTO dto){
        PersonaResource resource = this.personaService.update(dto,id);
        return ResponseEntity.ok(resource);
    }


}
