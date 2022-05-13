package dev.gerardcod.restapi.universidad.controller;

import dev.gerardcod.restapi.universidad.excepciones.BadRequestBodyException;
import dev.gerardcod.restapi.universidad.modelo.dtos.PersonaDTO;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.modelo.entidades.Profesor;
import dev.gerardcod.restapi.universidad.servicios.PersonaDAO;
import dev.gerardcod.restapi.universidad.servicios.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("profesores")
public class ProfesorController {

    @Autowired
    @Qualifier("profesorService")
    private PersonaDAO profesoresService;

    @PostMapping
    public ResponseEntity<PersonaDTO> crearProfesor(@RequestBody Persona profesor, BindingResult result) {

        if (result.hasFieldErrors())
            throw new BadRequestBodyException("Hay errores en tu petición", result.getFieldErrors());

        Persona profesorCreado = profesoresService.guardar(profesor);
        URI profesorCreadoURI = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(profesorCreado.getId()).toUri();

        return ResponseEntity.created(profesorCreadoURI)
                .body(PersonaDTO.fromEntity(profesorCreado));
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> buscarTodos() {
        List<Profesor> profesores = (List<Profesor>) ((ProfesorDAO) profesoresService).buscarTodosProfesores();

        List<PersonaDTO> profesoresDTO = profesores.stream()
                .map(PersonaDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(profesoresDTO);
    }
}
