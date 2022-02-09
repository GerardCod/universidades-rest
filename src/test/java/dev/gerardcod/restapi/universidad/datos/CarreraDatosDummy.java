package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.modelo.entidades.Carrera;

public class CarreraDatosDummy {

    public static Carrera carrera01() {
        return new Carrera(1L, "Ingeniería en Sistemas", 40, 4, "gaguilar");
    }

    public static Carrera carrera02() {
        return new Carrera(2L, "Licenciatura en Criminología", 40, 3, "gaguilar");
    }

    public static Carrera carrera03() {
        return new Carrera(3L, "Ingeniería Industrial", 45, 4, "gaguilar");
    }

}
