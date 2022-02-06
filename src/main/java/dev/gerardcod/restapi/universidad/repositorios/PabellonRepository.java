package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon, Long> {

    Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findPabellonesByNombre(String nombre);

}
