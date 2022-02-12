package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.AlumnoDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.AlumnoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlumnoDAOTest {

    private AlumnoRepository repository;
    private AlumnoDAO dao;

    @BeforeEach
    void setUp() {
        repository = mock(AlumnoRepository.class);
        dao = new AlumnoDAOImpl(repository);
    }

    @Test
    void buscarAlumnosPorNombre() {
        String carreraNombre = "Ingeniería en Sistemas";
        when(repository.buscarAlumnosPorNombre(carreraNombre))
                .thenReturn(List.of(AlumnoDatosDummy.alumno01()));

        List<Persona> alumnos = (List<Persona>) dao.buscarAlumnosPorNombre(carreraNombre);
        assertThat(alumnos.get(0)).isEqualTo(AlumnoDatosDummy.alumno01());
        verify(repository).buscarAlumnosPorNombre(carreraNombre);
    }
}