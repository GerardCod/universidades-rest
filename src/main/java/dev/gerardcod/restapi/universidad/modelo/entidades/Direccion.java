package dev.gerardcod.restapi.universidad.modelo.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion implements Serializable {

    private String calle;
    private String numero;
    private String codigoPostal;
    private String departamento;
    private String piso;
    private String localidad;

}
