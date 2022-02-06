package dev.gerardcod.restapi.universidad;

import dev.gerardcod.restapi.universidad.enumeradores.TipoEmpleado;
import dev.gerardcod.restapi.universidad.enumeradores.TipoPizarron;
import dev.gerardcod.restapi.universidad.modelo.entidades.*;
import dev.gerardcod.restapi.universidad.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class TestUniversidad implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;

    @Autowired
    private AlumnoDAO alumnoServicio;

    @Autowired
    private ProfesorDAO profesorServicio;

    @Autowired
    private EmpleadoDAO empleadoServicio;

    @Autowired
    private AulaDAO aulaServicio;

    @Autowired
    private PabellonDAO pabellonServicio;

    @Override
    public void run(String... args) throws Exception {
        /*Carrera ingenieriaSistemas = new Carrera(null, "Ingeniería en Sistemas", 60, 5, "gagular");
        Carrera carreraGuardada = servicio.guardar(ingenieriaSistemas);
        System.out.println(carreraGuardada);

        Direccion direccion = new Direccion("Siempre viva",
                "2434",
                "75720",
                "",
                "",
                "Puebla");

        BigDecimal sueldo = new BigDecimal(25000);
        Persona profesor = new Profesor(null, "Gerardo", "Aguilar", "1234567891", "gaguilar", direccion, sueldo);
        Profesor profesorGuardado = (Profesor) profesorServicio.guardar(profesor);
        System.out.println("Profesor creado");

        Set<Carrera> carrerasAsignadas = new HashSet<>();
        carrerasAsignadas.add(carreraGuardada);
        profesorGuardado.setCarreras(carrerasAsignadas);

        profesorServicio.guardar(profesorGuardado);
        System.out.println("Profesor actualizado");

        List<Persona> personas = (List<Persona>) profesorServicio.findProfesoresByCarrera("Ingeniería en Sistemas");
        personas.forEach(System.out::println);*/

        /*Direccion direccion = new Direccion("Calle random",
                "8950",
                "89523",
                "78",
                "4",
                "Sinaloa");
        BigDecimal sueldoEmpleado = new BigDecimal(15000);
        Persona empleado = new Empleado(null, "Abelardo", "Martínez", "9876543210", "gaguilar", direccion, sueldoEmpleado, TipoEmpleado.MANTENIMIENTO);

        empleadoServicio.guardar(empleado);*/

        /*List<Persona> empleadosMantenimiento = (List<Persona>) empleadoServicio.findEmpleadoByTipoEmpleado(TipoEmpleado.MANTENIMIENTO);
        empleadosMantenimiento.forEach(System.out::println);*/

        /*List<Carrera> carrerasFiltradas = (List<Carrera>) servicio.buscarCarrerasPorProfesorYApellido("Gerardo", "Aguilar");
        carrerasFiltradas.forEach(System.out::println);*/

        /*Aula aula = new Aula(null, 19, "10x15", 30, TipoPizarron.BLANCA, "gaguilar");
        aulaServicio.guardar(aula);

        List<Aula> aulasFiltradas = (List<Aula>) aulaServicio.findAulasByTipoPizarron(TipoPizarron.BLANCA);
        aulasFiltradas.forEach(System.out::println);*/

        /*Direccion direccionPabellon = new Direccion("Heroes de la Independencia", "456", "75725", "", "", "Puebla");
        Pabellon pabellon = new Pabellon(null, 1200.00, "Ada Lovelace", direccionPabellon, "gaguilar");

        pabellonServicio.guardar(pabellon);*/

        /*List<Pabellon> pabellonesPuebla = (List<Pabellon>) pabellonServicio.findPabellonesByDireccionLocalidad("Puebla");
        pabellonesPuebla.forEach(System.out::println);*/

        /*List<Pabellon> pabellonesFiltrados = (List<Pabellon>) pabellonServicio.findPabellonesByNombre("Ada Lovelace");
        Pabellon pabellon = pabellonesFiltrados.get(0);

        Optional<Aula> aulaOpcional = aulaServicio.findAulaByNumeroAula(19);

        if (aulaOpcional.isPresent()) {
            Aula aula = aulaOpcional.get();
            aula.setPabellon(pabellon);
            aulaServicio.guardar(aula);
            System.out.println("Aula actualizada");
        }*/

        /*List<Aula> aulasFiltradas = (List<Aula>) aulaServicio.findAulasByPabellonNombre("Ada Lovelace");
        aulasFiltradas.forEach(System.out::println);*/
    }
}
