package dev.gerardcod.restapi.universidad.excepciones;

import dev.gerardcod.restapi.universidad.modelo.dtos.BadRequestBodyField;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BadRequestBodyException extends RuntimeException {

    private List<BadRequestBodyField> errors;

    public BadRequestBodyException(String message, List<FieldError> errors) {
        super(message);
        this.errors = errors.stream()
                .map(BadRequestBodyField::fromFieldError)
                .collect(Collectors.toList());
    }

}
