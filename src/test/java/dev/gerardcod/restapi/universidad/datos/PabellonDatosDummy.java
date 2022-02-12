package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.modelo.entidades.Direccion;
import dev.gerardcod.restapi.universidad.modelo.entidades.Pabellon;

public class PabellonDatosDummy {

    public static Pabellon pabellon01() {

        Direccion direccion = new Direccion(
                "Random street",
                "53704",
                "75725",
                "",
                "1",
                "Tehuacán"
        );

        Pabellon pabellon = new Pabellon(null, 1000.00,"Ada Lovelace", direccion, "gaguilar");
        return pabellon;
    }

    public static Pabellon pabellon02() {
        Direccion direccion = new Direccion(
                "Random street",
                "53704",
                "75725",
                "",
                "2",
                "Tehuacán"
        );

        Pabellon pabellon = new Pabellon(null, 1000.00,"Alan Turing", direccion, "gaguilar");
        return pabellon;
    }

    public static Pabellon pabellon03() {
        Direccion direccion = new Direccion(
                "Random street",
                "53704",
                "75725",
                "",
                "3",
                "Tehuacán"
        );

        Pabellon pabellon = new Pabellon(null, 1000.00,"Hannah Hamilton", direccion, "gaguilar");
        return pabellon;
    }

}
