package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.modelo.entidades.Profesor;

import java.util.HashSet;
import java.util.Set;

public class CarreraDatosDummy {

    public static Carrera carrera01() {
        return new Carrera(
                1L,
                "Ingeniería en Sistemas",
                40,
                4,
                "gaguilar");
    }

    public static Carrera carrera02() {
        return new Carrera(
                2L,
                "Licenciatura en Criminología",
                40,
                3,
                "gaguilar");
    }

    public static Carrera carrera03() {
        return new Carrera(
                3L,
                "Ingeniería Industrial",
                45,
                4,
                "gaguilar");
    }

    public static Carrera carrera04() {

        Carrera carrera = new Carrera(4L, "Licenciatura en Física", 45, 5, "gaguilar");
        Set<Profesor> profesores = new HashSet<>();
        profesores.add(ProfesorDatosDummy.profesor01());

        carrera.setProfesores(profesores);
        return carrera;
    }
}
