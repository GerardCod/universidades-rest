package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;

public interface EmpleadoDAO extends PersonaDAO {
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
