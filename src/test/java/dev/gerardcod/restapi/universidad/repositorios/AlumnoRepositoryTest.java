package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.AlumnoDatosDummy;
import dev.gerardcod.restapi.universidad.datos.CarreraDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Alumno;
import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    private AlumnoRepository repository;

    @Autowired
    private CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        repository.save(AlumnoDatosDummy.alumno01());
        repository.save(AlumnoDatosDummy.alumno02());
        repository.save(AlumnoDatosDummy.alumno03());
        carreraRepository.save(CarreraDatosDummy.carrera01());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void buscarAlumnosPorNombre() {
        Optional<Carrera> carreraFound = carreraRepository.findById(1L);

        if (carreraFound.isEmpty())
            throw new EntityNotFoundException("No se encontró una carrera con id " + 1L);

        Optional<Persona> alumnoFound = repository.findById(1L);

        if (alumnoFound.isEmpty())
            throw new EntityNotFoundException("No se encontró un alumno con id " + 1L);

        Alumno alumno = (Alumno) alumnoFound.get();

        alumno.setCarrera(carreraFound.get());
        repository.save(alumno);
        List<Persona> alumnosSistemas = (List<Persona>) repository.buscarAlumnosPorNombre("Ingeniería en Sistemas");

        assertThat(alumnosSistemas.size()).isGreaterThan(0);

        Alumno alumnoSistemas = (Alumno) alumnosSistemas.get(0);
        assertThat(alumnoSistemas).isEqualTo(alumno);
    }
}