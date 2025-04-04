package Alumno;

import Materia.Materia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    private String mail;
    @Getter
    private List<Materia> materiasAprobadas;

}
