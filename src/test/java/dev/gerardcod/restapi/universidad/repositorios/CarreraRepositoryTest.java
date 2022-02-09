package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.CarreraDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    private CarreraRepository repositorio;

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
        assertEquals(carreras.size(), 1);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {

    }

    @Test
    void buscarCarrerasPorProfesorYApellido() {

    }
}