package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.EmpleadoDatosDummy;
import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmpleadoRepositoryTest {

    @Autowired
    private EmpleadoRepository repository;

    @BeforeEach
    void setUp() {
        repository.save(EmpleadoDatosDummy.empleado01());
        repository.save(EmpleadoDatosDummy.empleado02());
        repository.save(EmpleadoDatosDummy.empleado03());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findEmpleadoByTipoEmpleado() {
        List<Persona> empleadosMantenimiento = (List<Persona>) repository.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
        assertThat(empleadosMantenimiento.size()).isEqualTo(2);
    }
}