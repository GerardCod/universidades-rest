package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {

    @Autowired
    public PersonaDAOImpl(PersonaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repositorio.buscarPorNombreYApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni) {
        return repositorio.buscarPorDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonasPorApellido(String apellido) {
        return repositorio.buscarPersonasPorApellido(apellido);
    }
}
