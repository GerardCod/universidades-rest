package dev.gerardcod.restapi.universidad;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlladorPrueba {
	
@RequestMapping("/saludo")
public String mensajePrueba() {
	
	return "Hola, soy Ramiro";
}

}
