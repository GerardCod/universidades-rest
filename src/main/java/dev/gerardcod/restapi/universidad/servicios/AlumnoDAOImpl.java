package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Alumno;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.AlumnoRepository;
import dev.gerardcod.restapi.universidad.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("alumnoService")
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumno") PersonaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarAlumnosPorNombre(String nombre) {
        return ((AlumnoRepository) repositorio).buscarAlumnosPorNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> buscarTodosAlumnos() {
        return ((AlumnoRepository) repositorio).findAllAlumnos();
    }


}
