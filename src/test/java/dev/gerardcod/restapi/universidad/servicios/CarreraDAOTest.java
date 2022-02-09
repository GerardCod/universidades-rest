package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.CarreraDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.repositorios.CarreraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CarreraDAOTest {

    CarreraDAO carreraDAO;
    CarreraRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(repository);
    }

    @Test
    void findCarrerasByNombreContains() {
        String nombreCarrera = "Ingeniería";
        when(repository.findCarrerasByNombreContains(nombreCarrera))
                .thenReturn(Arrays.asList(CarreraDatosDummy.carrera01(), CarreraDatosDummy.carrera03()));

        List<Carrera> carreraList = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombreCarrera);

        assertThat(carreraList.get(0)).isEqualTo(CarreraDatosDummy.carrera01());
        assertThat(carreraList.get(1)).isEqualTo(CarreraDatosDummy.carrera03());

        verify(repository).findCarrerasByNombreContains(nombreCarrera);
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