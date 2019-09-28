package lopez.santiago.springRest.controller;


import lopez.santiago.springRest.model.Persona;
import lopez.santiago.springRest.exception.ResourceNotFoundException;
import lopez.santiago.springRest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/persona")
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    // Get a Single Note
    @GetMapping("/persona/{id_persona}")
    public Persona getPersonaById(@PathVariable(value = "id_persona") Long personaId) {
        return personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
    }

    // Update a Persona
    @PutMapping("/persona/{id_persona}")
    public Persona updatePersona(@PathVariable(value = "id_persona") Long personaId,
                           @Valid @RequestBody Persona personaDetalles) {

        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));

        persona.setNombre(personaDetalles.getNombre());
        persona.setApellido(personaDetalles.getApellido());

        Persona updatedPersona = personaRepository.save(persona);
        return updatedPersona;
    }

    // Delete a Persona
    @DeleteMapping("/persona/{id_persona}")
    public ResponseEntity<?> deletePersona(@PathVariable(value = "id_persona") Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));

        personaRepository.delete(persona);

        return ResponseEntity.ok().build();
    }
}