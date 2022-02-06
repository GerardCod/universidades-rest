package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumno")
public interface AlumnoRepository extends PersonaRepository {

    @Query("select a from Alumno a where a.carrera.nombre = ?1")
    Iterable<Persona> buscarAlumnosPorNombre(String nombre);

}
