package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;

import java.util.Optional;


public interface PersonaDAO extends GenericoDAO<Persona> {
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    Optional<Persona> buscarPorDni(String dni);

    Iterable<Persona> buscarPersonasPorApellido(String apelllido);
}
