package dev.gerardcod.restapi.universidad.modelo.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carreras", schema = "universidad")
public class Carrera implements Serializable {
    private static final long serialVersionUID = 123_443_245_779L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true, length = 80)
    private String nombre;

    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;

    @Column(name = "cantidad_anios")
    private Integer cantidadAnios;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;

    @ManyToMany(mappedBy = "carreras", fetch = FetchType.LAZY)
    private Set<Profesor> profesores;

    @Column(name = "usuario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    public Carrera(Long id, String nombre, Integer cantidadMaterias, Integer cantidadAnios, String usuarioCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
        this.usuarioCreacion = usuarioCreacion;
    }

    @PrePersist
    private void prePersist() {
        fechaCreacion = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        fechaModificacion = new Date();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Carrera))
            return false;

        Carrera otro = (Carrera) obj;
        return Objects.equals(getId(), otro.getId()) && Objects.equals(getNombre(), otro.getNombre());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carrera{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", cantidadMaterias=").append(cantidadMaterias);
        sb.append(", cantidadAnios=").append(cantidadAnios);
        sb.append(", usuarioCreacion='").append(usuarioCreacion).append('\'');
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", fechaModificacion=").append(fechaModificacion);
        sb.append('}');
        return sb.toString();
    }
}
