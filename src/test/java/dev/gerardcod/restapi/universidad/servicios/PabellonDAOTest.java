package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.PabellonDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;
import dev.gerardcod.restapi.universidad.repositorios.PabellonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PabellonDAOTest {

    PabellonRepository repository;
    PabellonDAO dao;

    @BeforeEach
    void setUp() {
        repository = mock(PabellonRepository.class);
        dao = new PabellonDAOImpl(repository);
    }

    @Test
    void findPabellonesByDireccionLocalidad() {
        String localidad = "Tehuacán";
        when(repository.findPabellonesByDireccionLocalidad(localidad))
                .thenReturn(List.of(
                        PabellonDatosDummy.pabellon01(),
                        PabellonDatosDummy.pabellon02(),
                        PabellonDatosDummy.pabellon03()
                        ));

        List<Pabellon> pabellonesLocalidad = (List<Pabellon>) dao.findPabellonesByDireccionLocalidad(localidad);

        assertThat(pabellonesLocalidad.size()).isGreaterThan(0);

        assertThat(pabellonesLocalidad.get(0)).isEqualTo(PabellonDatosDummy.pabellon01());
        assertThat(pabellonesLocalidad.get(1)).isEqualTo(PabellonDatosDummy.pabellon02());
        assertThat(pabellonesLocalidad.get(2)).isEqualTo(PabellonDatosDummy.pabellon03());
        verify(repository).findPabellonesByDireccionLocalidad(localidad);
    }

    @Test
    void findPabellonesByNombre() {
        String nombre = "Ada Lovelace";
        when(repository.findPabellonesByNombre(nombre))
                .thenReturn(List.of(PabellonDatosDummy.pabellon01()));

        List<Pabellon> pabellones = (List<Pabellon>) dao.findPabellonesByNombre(nombre);
        assertThat(pabellones.get(0)).isEqualTo(PabellonDatosDummy.pabellon01());
        verify(repository).findPabellonesByNombre(nombre);
    }
}