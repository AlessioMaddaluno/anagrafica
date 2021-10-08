package it.alessiomaddaluno.anagrafica.controller;

import it.alessiomaddaluno.anagrafica.dto.PersonaDTO;
import it.alessiomaddaluno.anagrafica.dto.SearchPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.alessiomaddaluno.anagrafica.resource.PersonaResource;
import it.alessiomaddaluno.anagrafica.service.PersonaService;

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
