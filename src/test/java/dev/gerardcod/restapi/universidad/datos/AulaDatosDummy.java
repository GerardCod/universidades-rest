package dev.gerardcod.restapi.universidad.datos;

import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.Aula;

public class AulaDatosDummy {

    public static Aula  aula01() {
        return new Aula(null, 14, "10x15", 25, TipoPizarron.BLANCA, "gaguilar");
    }

    public static Aula aula02() {
        return new Aula(null, 15, "10x15", 25, TipoPizarron.TIZA, "gaguilar");
    }

    public static Aula aula03() {
        return new Aula(null, 16, "10x20", 40, TipoPizarron.BLANCA, "gaguilar");
    }
}
