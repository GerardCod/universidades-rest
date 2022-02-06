package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.Aula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Long> {

    Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron);

    Iterable<Aula> findAulasByPabellonNombre(String nombre);

    Optional<Aula> findAulaByNumeroAula(Integer numeroAula);

}
