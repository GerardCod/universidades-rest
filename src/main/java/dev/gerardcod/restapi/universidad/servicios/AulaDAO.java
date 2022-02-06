package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.Aula;

import java.util.Optional;

public interface AulaDAO extends GenericoDAO<Aula> {

    Iterable<Aula> findAulasByTipoPizarron(TipoPizarron tipoPizarron);

    Iterable<Aula> findAulasByPabellonNombre(String nombre);

    Optional<Aula> findAulaByNumeroAula(Integer numeroAula);

}
