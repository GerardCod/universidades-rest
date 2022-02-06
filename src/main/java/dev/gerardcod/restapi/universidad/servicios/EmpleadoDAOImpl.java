package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.EmpleadoRepository;
import dev.gerardcod.restapi.universidad.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleado") PersonaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository) repositorio).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
