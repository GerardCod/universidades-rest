package dev.gerardcod.restapi.universidad.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ManuelController {

    @GetMapping("/manuel")
    public ResponseEntity<String> manuel() {
        return ResponseEntity.ok("Manuel");
    }
}
