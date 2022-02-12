package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.CarreraDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.repositorios.CarreraRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test de findCarrerasByNombreContains")
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
    @DisplayName("When findCarrerasByNombreContainsIgnoreCase then return list with elements")
    void findCarrerasByNombreContainsIgnoreCase() {
        String nombreCarrera = "licenciatura";
        when(repository.findCarrerasByNombreContainsIgnoreCase(nombreCarrera))
                .thenReturn(List.of(CarreraDatosDummy.carrera02()));

        List<Carrera> carreraList = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombreCarrera);

        assertEquals(carreraList.get(0), CarreraDatosDummy.carrera02());

        verify(repository).findCarrerasByNombreContainsIgnoreCase(nombreCarrera);
    }

    @Test
    @DisplayName("When findCarrerasByCantidadAniosAfter then return a list with elements in")
    void findCarrerasByCantidadAniosAfter() {
        Integer aniosAfter = 3;
        when(repository.findCarrerasByCantidadAniosAfter(aniosAfter))
                .thenReturn(List.of(CarreraDatosDummy.carrera01(), CarreraDatosDummy.carrera03()));

        List<Carrera> carreraList = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(aniosAfter);

        assertEquals(carreraList.get(0), CarreraDatosDummy.carrera01());
        assertEquals(carreraList.get(1), CarreraDatosDummy.carrera03());

        verify(repository).findCarrerasByCantidadAniosAfter(aniosAfter);
    }

    @Test
    @DisplayName("When buscarCarrerasPorProfesorYApellido then return a list with elements")
    void buscarCarrerasPorProfesorYApellido() {
        String nombreProfesor = "Gerardo";
        String apellidoProfesor = "Aguilar";
        when(repository.buscarCarrerasPorProfesorYApellido(nombreProfesor, apellidoProfesor))
                .thenReturn(List.of(CarreraDatosDummy.carrera04()));

        List<Carrera> carreraList = (List<Carrera>) repository.buscarCarrerasPorProfesorYApellido(nombreProfesor, apellidoProfesor);

        assertEquals(carreraList.get(0), CarreraDatosDummy.carrera04());

        verify(repository).buscarCarrerasPorProfesorYApellido(nombreProfesor, apellidoProfesor);
    }
}