package Inscripcion;

import Alumno.Alumno;
import Materia.Materia;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Setter
public class Inscripcion {
    private final Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
    }


    public Boolean aprobada() {
        return this.materias.stream().allMatch(materia ->
                new HashSet<>(Optional.ofNullable(alumno.getMateriasAprobadas()).orElse(List.of()))
                        .containsAll(Optional.ofNullable(materia.getCorrelativas()).orElse(List.of()))
        );
    }

}
