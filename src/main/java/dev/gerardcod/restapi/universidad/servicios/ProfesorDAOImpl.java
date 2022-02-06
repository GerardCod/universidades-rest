package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.PersonaRepository;
import dev.gerardcod.restapi.universidad.repositorios.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {

    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesor") PersonaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String nombre) {
        return ((ProfesorRepository) repositorio).findProfesoresByCarrera(nombre);
    }
}
