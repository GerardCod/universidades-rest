package dev.gerardcod.restapi.universidad.servicios;

import dev.gerardcod.restapi.universidad.datos.ProfesorDatosDummy;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.repositorios.ProfesorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfesorDAOTest {

    private ProfesorRepository repository;
    private ProfesorDAO dao;

    @BeforeEach
    void setUp() {
        repository = mock(ProfesorRepository.class);
        dao = new ProfesorDAOImpl(repository);
    }

    @Test
    void findProfesoresByCarrera() {
        String carreraNombre = "Ingeniería en Sistemas";
        when(repository.findProfesoresByCarrera(carreraNombre))
                .thenReturn(List.of(
                        ProfesorDatosDummy.profesor01(),
                        ProfesorDatosDummy.profesor02()
                ));

        List<Persona> profesoresSistemas = (List<Persona>) dao.findProfesoresByCarrera(carreraNombre);

        assertThat(profesoresSistemas.size()).isGreaterThan(0);
        assertThat(profesoresSistemas.get(0)).isEqualTo(ProfesorDatosDummy.profesor01());
        assertThat(profesoresSistemas.get(1)).isEqualTo(ProfesorDatosDummy.profesor02());

        verify(repository).findProfesoresByCarrera(carreraNombre);
    }
}