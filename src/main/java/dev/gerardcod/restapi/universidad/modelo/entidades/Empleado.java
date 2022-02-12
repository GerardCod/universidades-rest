package dev.gerardcod.restapi.universidad.modelo.entidades;

import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona {
    private static final long serialVersionUID = 123_443_245_778L;

    @Column(name="sueldo")
    private BigDecimal sueldo;

    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmpleado tipo;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "pabellon_id", foreignKey = @ForeignKey(name = "fk_pabellon_empleado_id"))
    private Pabellon pabellon;

    public Empleado(Long id, String nombre, String apellido, String dni, String usuarioCreacion, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipo) {
        super(id, nombre, apellido, dni, usuarioCreacion, direccion);
        this.sueldo = sueldo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("sueldo=").append(sueldo);
        sb.append(", tipo=").append(tipo);
        sb.append(", pabellon=").append(pabellon);
        sb.append('}');
        return sb.toString();
    }
}
