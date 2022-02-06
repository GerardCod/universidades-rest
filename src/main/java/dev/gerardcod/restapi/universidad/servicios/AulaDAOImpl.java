package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.Aula;
import dev.gerardcod.restapi.universidad.repositorios.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AulaDAOImpl extends GenericoDAOImpl<Aula, AulaRepository> implements AulaDAO {

    @Autowired
    public AulaDAOImpl(AulaRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron) {
        return repositorio.findAulasByTipoPizarron(tipoPizarron);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Aula> findAulasByPabellonNombre(String nombre) {
        return repositorio.findAulasByPabellonNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Aula> findAulaByNumeroAula(Integer numeroAula) {
        return repositorio.findAulaByNumeroAula(numeroAula);
    }
}
