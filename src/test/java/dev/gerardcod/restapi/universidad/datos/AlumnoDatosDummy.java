package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.modelo.entidades.Alumno;
import dev.gerardcod.restapi.universidad.modelo.entidades.Direccion;

public class AlumnoDatosDummy {

    public static Alumno alumno01() {
        Direccion direccion = new Direccion(
                "Calle José María Morelos y Pavón",
                "2434",
                "75720",
                "",
                "",
                "Tehuacán"
        );

        return new Alumno(null, "Adalberto", "Calderón", "3517110274", "gaguilar",direccion);
    }

    public static Alumno alumno02() {
        Direccion direccion = new Direccion(
                "Calle Miguel Hidalgo",
                "1219",
                "75718",
                "",
                "",
                "Tehuacán"
        );

        return new Alumno(null, "Anahí", "Castillo", "3517110275", "gaguilar",direccion);
    }

    public static Alumno alumno03() {
        Direccion direccion = new Direccion(
                "Calle Lomas de la Soledad",
                "2320",
                "75728",
                "",
                "",
                "Tehuacán"
        );

        return new Alumno(null, "Lucero", "Jímenez", "3517110276", "gaguilar",direccion);
    }
}
