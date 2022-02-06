package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    @Query("select c from Carrera c join fetch c.profesores p where p.nombre = ?1 and p.apellido = ?2")
    Iterable<Carrera> buscarCarrerasPorProfesorYApellido(String nombre, String apellido);
}
