package dev.gerardcod.restapi.universidad.servicios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl<E, R extends CrudRepository<E, Long>> implements GenericoDAO<E> {

    protected final R repositorio;

    public GenericoDAOImpl(R repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> buscarPorId(Long id) {
        return repositorio.findById(id);
    }

    @Override
    @Transactional
    public E guardar(E entidad) {
        return repositorio.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        repositorio.deleteById(id);
    }
}
