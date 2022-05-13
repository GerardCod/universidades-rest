package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.modelo.entidades.Profesor;

public interface ProfesorDAO extends PersonaDAO {
    Iterable<Persona> findProfesoresByCarrera(String nombre);

    Iterable<Profesor> buscarTodosProfesores();
}
