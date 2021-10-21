package it.alessiomaddaluno.anagrafica.controller;

import it.alessiomaddaluno.anagrafica.dto.PersonaDTO;
import it.alessiomaddaluno.anagrafica.dto.SearchPersonaDTO;
import it.alessiomaddaluno.anagrafica.resource.PersonaResource;
import it.alessiomaddaluno.anagrafica.service.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    Logger logger = LoggerFactory.getLogger(PersonaController.class);

    // Create
    @PostMapping()
    public ResponseEntity<PersonaResource> insertPersona(@RequestBody PersonaDTO dto){
        logger.info("[insertPersona] START - input: {} ",dto);
        PersonaResource resource = this.personaService.insert(dto);
        logger.info("[insertPersona] END OK - output: {} ",resource);
        return ResponseEntity.ok(resource);
    }

    // Read
    @PostMapping("search")
    public ResponseEntity<Page<PersonaResource>> search(@RequestBody SearchPersonaDTO dto){
        logger.info("[search] START - input: {} ",dto);
        Page<PersonaResource> page = this.personaService.search(dto);
        logger.info("[search] END OK - output: {} ",page.getTotalElements());
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaResource> findById(@PathVariable("id") Long id){
        logger.info("[findById] START - input: {} ",id);
        PersonaResource resource = this.personaService.findById(id);
        logger.info("[findById] END OK - output: {} ",resource);
        return ResponseEntity.ok(resource);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Long id){
        logger.info("[deletePersona] START - input: {} ",id);
        this.personaService.delete(id);
        logger.info("[deletePersona] END OK - output: void ");
        return ResponseEntity.ok(null);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PersonaResource> updatePersona(@PathVariable("id") Long id, @RequestBody() PersonaDTO dto){
        logger.info("[updatePersona] START - input: id - {}, dto - {} ",id,dto);
        PersonaResource resource = this.personaService.update(dto,id);
        logger.info("[updatePersona] END OK - output: {} ",resource);
        return ResponseEntity.ok(resource);
    }


}
