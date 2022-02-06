package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;
import dev.gerardcod.restapi.universidad.repositorios.PabellonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository>  implements PabellonDAO {

    @Autowired
    public PabellonDAOImpl(PabellonRepository repositorio) {
        super(repositorio);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonesByDireccionLocalidad(String localidad) {
        return repositorio.findPabellonesByDireccionLocalidad(localidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Pabellon> findPabellonesByNombre(String nombre) {
        return repositorio.findPabellonesByNombre(nombre);
    }
}
