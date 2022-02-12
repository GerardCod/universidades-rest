package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.CarreraDatosDummy;
import dev.gerardcod.restapi.universidad.datos.ProfesorDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.modelo.entidades.Profesor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProfesorRepositoryTest {

    @Autowired
    private ProfesorRepository repository;

    @Autowired
    private CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        repository.save(ProfesorDatosDummy.profesor01());
        repository.save(ProfesorDatosDummy.profesor02());
        repository.save(ProfesorDatosDummy.profesor03());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("findProfesoresByCarrera regresa una lista con elementos")
    void findProfesoresByCarrera() {
        Optional<Persona> profesor = repository.findById(1L);

        if (profesor.isEmpty()) {
            throw new EntityNotFoundException("No se encontró el profesor con id " + 1L);
        }

        Profesor profesorEncontrado = (Profesor) profesor.get();
        Set<Carrera> carreraSet = new HashSet<>();

        Carrera carreraGuardada = carreraRepository.save(CarreraDatosDummy.carrera01());
        carreraSet.add(carreraGuardada);
        profesorEncontrado.setCarreras(carreraSet);
        repository.save(profesorEncontrado);

        List<Persona> profesoresPorCarrera = (List<Persona>) repository.findProfesoresByCarrera("Ingeniería en Sistemas");
        assertThat(profesoresPorCarrera.size()).isGreaterThan(0);
    }
}