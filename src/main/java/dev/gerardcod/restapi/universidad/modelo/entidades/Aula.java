package dev.gerardcod.restapi.universidad.modelo.entidades;

import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "aulas")
public class Aula implements Serializable {
    private static final long serialVersionUID = 123_443_245_780L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_aula", nullable = false)
    private Integer numeroAula;

    @Column(name = "medidas")
    private String medidas;

    @Column(name = "cantidad_pupitres")
    private Integer cantidadPupitres;

    @Column(name = "tipo_pizarron")
    @Enumerated(EnumType.STRING)
    private TipoPizarron tipoPizarron;

    @Column(name = "usuario_creacion", nullable = false)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;

    private Date fechaModificacion;

    @ManyToOne(optional = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "pabellon_id",foreignKey = @ForeignKey(name = "fk_pabellon_id"))
    private Pabellon pabellon;

    public Aula(Long id, Integer numeroAula, String medidas, Integer cantidadPupitres, TipoPizarron tipoPizarron, String usuarioCreacion) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.medidas = medidas;
        this.cantidadPupitres = cantidadPupitres;
        this.tipoPizarron = tipoPizarron;
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
    public int hashCode() {
        return Objects.hash(id, numeroAula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Aula))
            return false;

        Aula otro = (Aula) obj;
        return Objects.equals(getId(), otro.getId());
    }
}
