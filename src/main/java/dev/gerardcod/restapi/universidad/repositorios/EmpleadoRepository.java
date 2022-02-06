package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleado")
public interface EmpleadoRepository extends PersonaRepository {

    @Query("select e from Empleado e where e.tipo = ?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);

}
