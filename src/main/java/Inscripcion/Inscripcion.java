package Inscripcion;

import Alumno.Alumno;
import Materia.Materia;
import lombok.Setter;

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
        if(alumno.getMateriasAprobadas().isEmpty() && materias.stream().noneMatch(m -> m.tieneCorrelativas())) {
            return true;
        }
        return this.materias.stream().allMatch(materia ->
                alumno.getMateriasAprobadas().containsAll(Optional.ofNullable(materia.getCorrelativas()).orElse(List.of()))
        );
    }

}
