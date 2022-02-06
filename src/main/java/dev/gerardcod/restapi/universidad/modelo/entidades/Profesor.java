package dev.gerardcod.restapi.universidad.modelo.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="profesores", schema = "universidad")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona {

    private static final long serialVersionUID = 123_443_245_776L;

    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "profesor_carrera", schema = "universidad",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "carera_id")
    )
    private Set<Carrera> carreras;

    public Profesor(Long id, String nombre, String apellido, String dni, String usuarioCreacion, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, usuarioCreacion, direccion);
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("sueldo=").append(sueldo);
        sb.append('}');
        return sb.toString();
    }
}
