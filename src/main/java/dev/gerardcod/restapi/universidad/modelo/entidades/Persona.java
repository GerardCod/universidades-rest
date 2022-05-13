package dev.gerardcod.restapi.universidad.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Alumno.class, name = "alumno"),
        @JsonSubTypes.Type(value = Profesor.class, name = "profesor"),
        @JsonSubTypes.Type(value = Empleado.class, name = "empleado")
})
public abstract class Persona implements Serializable {
    private static final long serialVersionUID = 123_443_245_775L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 60)
    @NotBlank
    @NotEmpty
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 60)
    @NotBlank
    @NotEmpty
    private String apellido;

    @Column(name = "dni",unique = true, nullable = false, length = 10)
    @NotBlank
    @NotEmpty
    private String dni;
    @NotEmpty
    private String usuarioCreacion;
    private Date fechaCreacion;
    private Date fechaModificacion;

    @Embedded
    private Direccion direccion;

    public Persona(Long id, String nombre, String apellido, String dni, String usuarioCreacion, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuarioCreacion = usuarioCreacion;
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDni(), getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Persona))
            return false;

        Persona otro = (Persona) obj;
        return Objects.equals(dni, otro.getDni()) && Objects.equals(id, otro.getId());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", usuarioCreacion='").append(usuarioCreacion).append('\'');
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", fechaModificacion=").append(fechaModificacion);
        sb.append(", direccion=").append(direccion);
        sb.append('}');
        return sb.toString();
    }

    @PrePersist
    private void beforePersist() {
        this.fechaCreacion = new Date();
    }

    @PreUpdate
    private void beforeUpdate() {
        this.fechaModificacion = new Date();
    }
}
