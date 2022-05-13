package dev.gerardcod.restapi.universidad.excepciones.controlador;

import dev.gerardcod.restapi.universidad.excepciones.BadRequestBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BadRequestBodyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handle(BadRequestBodyException ex) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", ex.getMessage());
        response.put("errors", ex.getErrors());
        return response;
    }

}
