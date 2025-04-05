package Inscripcion;

import Alumno.Alumno;
import Materia.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

class InscripcionTest {
    @Test
    @DisplayName("Alumno se inscribe a Diseño con todas las correlativas")
    public void aprobadaTrue(){
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setLegajo("2111116");
        alumno.setMail("jperez@gmail.com");

        Materia materia1 = new Materia();
        materia1.setNombre("Algoritmos");
        materia1.setHorario(LocalTime.of(10, 0, 0));
        materia1.setCorrelativas(List.of());

        Materia materia2 = new Materia();
        materia2.setNombre("Paradigmas");
        materia2.setHorario(LocalTime.of(9, 15, 0));
        materia2.setCorrelativas(List.of(materia1));

        Materia materia3 = new Materia();
        materia3.setNombre("Diseño");
        materia3.setHorario(LocalTime.of(8, 30, 0));
        materia3.setCorrelativas(List.of(materia1,materia2));

        alumno.setMateriasAprobadas(List.of(materia1,materia2));

        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.setMaterias(List.of(materia3));

        Assertions.assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Alumno se inscribe a Diseño sin haber aprobado algoritmos")
    public void aprobadaFalse(){
        Alumno alumno = new Alumno();
        alumno.setNombre("Pedro");
        alumno.setApellido("Suarez");
        alumno.setLegajo("2111116");
        alumno.setMail("peposuarez@gmail.com");

        Materia materia1 = new Materia();
        materia1.setNombre("Algoritmos");
        materia1.setHorario(LocalTime.of(10, 0, 0));
        materia1.setCorrelativas(List.of());

        Materia materia2 = new Materia();
        materia2.setNombre("Paradigmas");
        materia2.setHorario(LocalTime.of(9, 15, 0));
        materia2.setCorrelativas(List.of(materia1));

        Materia materia3 = new Materia();
        materia3.setNombre("ADS");
        materia3.setHorario(LocalTime.of(10, 0, 0));
        materia3.setCorrelativas(List.of(materia1));


        Materia materia4 = new Materia();
        materia4.setNombre("Diseño");
        materia4.setHorario(LocalTime.of(10, 0, 0));
        materia4.setCorrelativas(List.of(materia1,materia2,materia3));

        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.setMaterias(List.of(materia4));

        alumno.setMateriasAprobadas(List.of(materia1));

        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("ingrsante se inscribe a algoritmos")
    public void inscripcionIngresante(){
        Alumno alumno = new Alumno();
        alumno.setNombre("Pedro");
        alumno.setApellido("Suarez");
        alumno.setLegajo("2111116");
        alumno.setMail("peposuarez@gmail.com");

        Materia materia1 = new Materia();
        materia1.setNombre("Algoritmos");
        materia1.setHorario(LocalTime.of(10, 0, 0));
        materia1.setCorrelativas(List.of());

        Materia materia2 = new Materia();
        materia2.setNombre("analisis 1");
        materia2.setHorario(LocalTime.of(10, 0, 0));
        materia2.setCorrelativas(List.of());

        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.setMaterias(List.of(materia1,materia2));

        Assertions.assertTrue(inscripcion.aprobada());
    }
}
