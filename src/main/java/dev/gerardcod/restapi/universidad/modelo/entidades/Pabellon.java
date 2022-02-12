package dev.gerardcod.restapi.universidad.modelo.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pabellones")
public class Pabellon {
    private static final long serialVersionUID = 123_443_245_777L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "metros_cuadrados")
    private Double metrosCuadrados;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "codigoPostal",column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "departamento", column = @Column(name = "departamento"))
    })
    private Direccion direccion;

    @Column(name = "usuario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
    private Set<Aula> aulas;

    public Pabellon(Long id, Double metrosCuadrados, String nombre, Direccion direccion, String usuarioCreacion) {
        this.id = id;
        this.metrosCuadrados = metrosCuadrados;
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuarioCreacion = usuarioCreacion;
    }

    @PrePersist
    private void prePersist() {
        this.fechaCreacion = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        this.fechaModificacion = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pabellon pabellon = (Pabellon) o;

        return nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nombre.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pabellon{");
        sb.append("id=").append(id);
        sb.append(", metrosCuadrados=").append(metrosCuadrados);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", direccion=").append(direccion);
        sb.append(", usuarioCreacion='").append(usuarioCreacion).append('\'');
        sb.append(", fechaCreacion=").append(fechaCreacion);
        sb.append(", fechaModificacion=").append(fechaModificacion);
        sb.append('}');
        return sb.toString();
    }
}
