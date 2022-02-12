package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.modelo.entidades.Direccion;
import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import dev.gerardcod.restapi.universidad.modelo.entidades.Profesor;

import java.math.BigDecimal;

public class ProfesorDatosDummy {

    public static Profesor profesor01() {
        Direccion direccion = new Direccion(
                "José María Morelos y Pavón",
                "2434",
                "75720",
                "",
                "",
                "Tehuacán"
        );

        return new Profesor(null, "Gerardo", "Aguilar", "4517110274", "gaguilar", direccion, new BigDecimal(25000));
    }

    public static Profesor profesor02() {
        Direccion direccion = new Direccion(
                "3 Oriente",
                "2220",
                "75724",
                "",
                "",
                "Tehuacán"
        );

        return new Profesor(null, "Fausto", "Hernández", "3890231024", "gaguilar", direccion, new BigDecimal(25000));
    }

    public static Profesor profesor03() {
        Direccion direccion = new Direccion(
                "Heroes de la Independencia",
                "1502",
                "75730",
                "",
                "",
                "Tehuacán"
        );

        return new Profesor(null, "Laura", "Rosas", "1938830458", "gaguilar", direccion, new BigDecimal(25000));
    }

}
