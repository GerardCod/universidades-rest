package dev.gerardcod.restapi.universidad.modelo.dtos;

import dev.gerardcod.restapi.universidad.modelo.entidades.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;

    public static PersonaDTO fromEntity(Persona persona) {
        return new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getDni());
    }
}
