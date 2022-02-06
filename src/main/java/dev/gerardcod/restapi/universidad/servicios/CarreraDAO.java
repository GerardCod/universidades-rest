package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericoDAO<Carrera> {
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    Iterable<Carrera> buscarCarrerasPorProfesorYApellido(String nombre, String apellido);
}
