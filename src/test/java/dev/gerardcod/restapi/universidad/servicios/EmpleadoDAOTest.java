package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.EmpleadoDatosDummy;
import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.EmpleadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpleadoDAOTest {

    private EmpleadoRepository repository;
    private EmpleadoDAO dao;

    @BeforeEach
    void setUp() {
        repository = mock(EmpleadoRepository.class);
        dao = new EmpleadoDAOImpl(repository);
    }

    @Test
    void findEmpleadoByTipoEmpleado() {
        when(repository.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO))
                .thenReturn(List.of(
                        EmpleadoDatosDummy.empleado01(),
                        EmpleadoDatosDummy.empleado03()
                ));

        List<Persona> empleadosMantenimiento = (List<Persona>) dao.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);

        assertThat(empleadosMantenimiento.size()).isGreaterThan(0);
        assertThat(empleadosMantenimiento.get(0)).isEqualTo(EmpleadoDatosDummy.empleado01());
        assertThat(empleadosMantenimiento.get(1)).isEqualTo(EmpleadoDatosDummy.empleado03());

        verify(repository).findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
    }
}