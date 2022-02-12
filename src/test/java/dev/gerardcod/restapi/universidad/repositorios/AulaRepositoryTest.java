package dev.gerardcod.restapi.universidad.repositorios;

import dev.gerardcod.restapi.universidad.datos.AulaDatosDummy;
import dev.gerardcod.restapi.universidad.datos.PabellonDatosDummy;
import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.Aula;
import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AulaRepositoryTest {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private PabellonRepository pabellonRepository;

    @BeforeEach
    void setUp() {
        repository.save(AulaDatosDummy.aula01());
        repository.save(AulaDatosDummy.aula02());
        repository.save(AulaDatosDummy.aula03());
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("findAulasTipoPizarron should return a list with two elements")
    void findAulasByTipoPizarron() {
        List<Aula> aulasFiltradas = (List<Aula>) repository.findAulasByTipoPizarron(TipoPizarron.BLANCA);
        assertThat(aulasFiltradas.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("findAulasPabellonNombre returns a list with an element")
    void findAulasByPabellonNombre() {
        Pabellon pabellonSaved = pabellonRepository.save(PabellonDatosDummy.pabellon01());
        Optional<Aula> aulaFound = repository.findById(1L);

        if (aulaFound.isEmpty()) {
            throw new EntityNotFoundException("No se encontró el aula con el id " + 1L);
        }

        Aula aula = aulaFound.get();
        aula.setPabellon(pabellonSaved);
        repository.save(aula);

        List<Aula> aulasFiltradas = (List<Aula>) repository.findAulasByPabellonNombre("Ada Lovelace");
        assertThat(aulasFiltradas.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("findAulaByNumeroAula returns an entity")
    void findAulaByNumeroAula() {
        Optional<Aula> aulaFound = repository.findAulaByNumeroAula(15);

        if (aulaFound.isEmpty()) {
            throw new EntityNotFoundException("No se encontró el aula con el número " + 15);
        }

        assertThat(aulaFound.get()).isNotNull();
    }
}