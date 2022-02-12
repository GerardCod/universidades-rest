package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.AulaDatosDummy;
import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.Aula;
import dev.gerardcod.restapi.universidad.repositorios.AulaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AulaDAOTest {

    AulaDAO aulaDAO;
    AulaRepository aulaRepository;

    @BeforeEach
    void setUp() {
        aulaRepository = mock(AulaRepository.class);
        aulaDAO = new AulaDAOImpl(aulaRepository);
    }

    @Test
    void findAulasByTipoPizarron() {
        when(aulaRepository.findAulasByTipoPizarron(TipoPizarron.TIZA))
                .thenReturn(List.of(AulaDatosDummy.aula02()));

        List<Aula> aulasTiza = (List<Aula>) aulaDAO.findAulasByTipoPizarron(TipoPizarron.TIZA);

        assertThat(aulasTiza.size()).isGreaterThan(0);
        assertThat(aulasTiza.get(0)).isEqualTo(AulaDatosDummy.aula02());

        verify(aulaRepository).findAulasByTipoPizarron(TipoPizarron.TIZA);
    }

    @Test
    void findAulasByPabellonNombre() {
        when(aulaRepository.findAulasByPabellonNombre("Ada Lovelace"))
                .thenReturn(List.of(AulaDatosDummy.aula04()));

        List<Aula> aulaPabellon = (List<Aula>) aulaDAO.findAulasByPabellonNombre("Ada Lovelace");
        assertThat(aulaPabellon.get(0)).isEqualTo(AulaDatosDummy.aula04());

        verify(aulaRepository).findAulasByPabellonNombre("Ada Lovelace");
    }

    @Test
    void findAulaByNumeroAula() {
        when(aulaRepository.findAulaByNumeroAula(16))
                .thenReturn(Optional.of(AulaDatosDummy.aula03()));

        Optional<Aula> aulaFound = aulaDAO.findAulaByNumeroAula(16);

        assertThat(aulaFound.get()).isEqualTo(AulaDatosDummy.aula03());
        verify(aulaRepository).findAulaByNumeroAula(16);
    }
}