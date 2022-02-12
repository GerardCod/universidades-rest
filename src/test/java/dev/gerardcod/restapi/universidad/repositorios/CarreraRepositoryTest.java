package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.CarreraDatosDummy;
import dev.gerardcod.restapi.universidad.datos.ProfesorDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.modelo.entidades.Profesor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    private CarreraRepository repositorio;

    @Autowired
    private ProfesorRepository profesorRepository;

    Logger LOGGER = LoggerFactory.getLogger(CarreraRepositoryTest.class);

    @BeforeEach
    void setUp() {
            repositorio.save(CarreraDatosDummy.carrera01());
            repositorio.save(CarreraDatosDummy.carrera02());
            repositorio.save(CarreraDatosDummy.carrera03());
    }

    @AfterEach
    void tearDown() {
        repositorio.deleteAll();
    }

    @Test
    void findCarrerasByNombreContains() {
        List<Carrera> carreras = (List<Carrera>) repositorio.findCarrerasByNombreContains("Sistemas");
        assertThat(carreras.size()).isGreaterThan(0);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        List<Carrera> carreras = (List<Carrera>) repositorio.findCarrerasByNombreContainsIgnoreCase("licenciatura");
        assertEquals(carreras.size(), 1);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        List<Carrera> carreras = (List<Carrera>) repositorio.findCarrerasByCantidadAniosAfter(3);
        assertEquals(carreras.size(), 2);
    }

    @Test
    void buscarCarrerasPorProfesorYApellido() {
        Optional<Carrera> carreraFound = repositorio.findById(1L);

        Profesor profesorGuardado = (Profesor) profesorRepository.save(ProfesorDatosDummy.profesor01());

        if (carreraFound.isPresent()) {
            Carrera carrera = carreraFound.get();
            Set<Carrera> carreraSet = new HashSet<>();
            carreraSet.add(carrera);
            profesorGuardado.setCarreras(carreraSet);
            profesorRepository.save(profesorGuardado);
        }

        List<Carrera> carreras = (List<Carrera>) repositorio.buscarCarrerasPorProfesorYApellido("Gerardo", "Aguilar");
        assertEquals(carreras.size(), 1);
    }
}