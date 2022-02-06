package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO {
    Iterable<Persona> buscarAlumnosPorNombre(String nombre);
}
