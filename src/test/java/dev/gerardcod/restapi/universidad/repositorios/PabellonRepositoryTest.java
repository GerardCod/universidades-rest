package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.PabellonDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PabellonRepositoryTest {

    @Autowired
    private PabellonRepository repository;

    @BeforeEach
    void setUp() {
        repository.save(PabellonDatosDummy.pabellon01());
        repository.save(PabellonDatosDummy.pabellon02());
        repository.save(PabellonDatosDummy.pabellon03());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findPabellonesByDireccionLocalidad() {
        List<Pabellon> pabellones = (List<Pabellon>) repository.findPabellonesByDireccionLocalidad("Tehuacán");
        assertThat(pabellones.size()).isEqualTo(3);
    }

    @Test
    void findPabellonesByNombre() {
        List<Pabellon> pabellones = (List<Pabellon>) repository.findPabellonesByNombre("Alan Turing");
        assertThat(pabellones.size()).isEqualTo(1);
    }
}