package dev.gerardcod.restapi.universidad.modelo.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
//@Table(name="alumnos", schema = "universidad")
@Table(name="alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona {
    private static final long serialVersionUID = 123_443_245_781L;

    @ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "carrera_id", foreignKey = @ForeignKey(name = "fk_carrera_id"))
    private Carrera carrera;

    public Alumno(Long id, String nombre, String apellido, String dni, String usuarioCreacion, Direccion direccion) {
        super(id, nombre, apellido, dni, usuarioCreacion, direccion);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("carrera=").append(carrera);
        sb.append('}');
        return sb.toString();
    }
}
