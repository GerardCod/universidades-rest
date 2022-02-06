package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.repositorios.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDAO {

    @Autowired
    public CarreraDAOImpl(CarreraRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repositorio.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repositorio.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios) {
        return repositorio.findCarrerasByCantidadAniosAfter(cantidadAnios);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> buscarCarrerasPorProfesorYApellido(String nombre, String apellido) {
        return repositorio.buscarCarrerasPorProfesorYApellido(nombre, apellido);
    }
}
