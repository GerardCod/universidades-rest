package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericoDAO<Pabellon> {

    Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findPabellonesByNombre(String nombre);

}
