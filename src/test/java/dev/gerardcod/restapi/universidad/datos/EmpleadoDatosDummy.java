package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.modelo.entidades.Direccion;
import dev.gerardcod.restapi.universidad.modelo.entidades.Empleado;

import java.math.BigDecimal;

public class EmpleadoDatosDummy {

    public static Empleado empleado01() {
        Direccion direccion = new Direccion(
                "Calle Siempre viva",
                "1204",
                "75719",
                "",
                "",
                "Tehuacán"
        );

        Empleado empleado = new Empleado(null, "Manuel", "Ávila", "7538401246", "gaguilar", direccion, new BigDecimal(20000), TipoEmpleado.MANTENIMIENTO);
        return empleado;
    }

    public static Empleado empleado02() {
        Direccion direccion = new Direccion(
                "Boulevard Héroes de Nacozari",
                "801",
                "75715",
                "",
                "",
                "Tehuacán"
        );

        Empleado empleado = new Empleado(null, "Rosa", "Piña", "9538401246", "gaguilar", direccion, new BigDecimal(25000), TipoEmpleado.ADMINISTRATIVO);
        return empleado;
    }

    public static Empleado empleado03() {
        Direccion direccion = new Direccion(
                "Avenida José Garcicrespo",
                "729",
                "75721",
                "",
                "",
                "Tehuacán"
        );

        Empleado empleado = new Empleado(null, "Estela", "Gutierrez", "9538401248", "gaguilar", direccion, new BigDecimal(20000), TipoEmpleado.MANTENIMIENTO);
        return empleado;
    }
}
