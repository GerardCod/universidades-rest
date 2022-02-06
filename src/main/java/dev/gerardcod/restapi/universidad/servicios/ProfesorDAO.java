package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;

public interface ProfesorDAO extends PersonaDAO {
    Iterable<Persona> findProfesoresByCarrera(String nombre);
}
