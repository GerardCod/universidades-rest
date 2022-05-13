package dev.gerardcod.restapi.universidad.controller;

import dev.gerardcod.restapi.universidad.excepciones.BadRequestBodyException;
import dev.gerardcod.restapi.universidad.modelo.dtos.PersonaDTO;
import dev.gerardcod.restapi.universidad.modelo.entidades.Alumno;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.servicios.AlumnoDAO;
import dev.gerardcod.restapi.universidad.servicios.PersonaDAO;
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
@RequestMapping("alumnos")
public class AlumnoController {

    @Autowired
    @Qualifier("alumnoService")
    private PersonaDAO alumnoService;

    @PostMapping
    public ResponseEntity<PersonaDTO> crearAlumno(@RequestBody Persona alumno, BindingResult result) {

        if (result.hasFieldErrors())
            throw new BadRequestBodyException("Hay errores en tu petición", result.getFieldErrors());

        Alumno alumnoCreado = (Alumno) alumnoService.guardar(alumno);
        URI alumnoCreadoURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(alumnoCreado.getId())
                .toUri();

        return ResponseEntity.created(alumnoCreadoURI)
                .body(PersonaDTO.fromEntity(alumnoCreado));
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> buscarAlumnos() {
        List<Alumno> alumnos = (List<Alumno>) ((AlumnoDAO) this.alumnoService).buscarTodosAlumnos();

        List<PersonaDTO> alumnosDTO = alumnos.stream()
                .map(PersonaDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(alumnosDTO);
    }
}
