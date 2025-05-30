package Materia;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Materia {
    private String nombre;
    private LocalTime horario;
    @Getter
    private List<Materia> correlativas = new ArrayList<>();

    public Boolean tieneCorrelativas(){
        return !this.correlativas.isEmpty();
    }
}
