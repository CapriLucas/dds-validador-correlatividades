package ar.edu.utn.frba.dds;

import java.util.Set;

public class Inscripcion {
    private Alumno alumno;
    private Set<Materia> materias;

    public Inscripcion(Alumno alumno, Set<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public Boolean aprobada(){
        return materias.stream().allMatch(alumno::cumpleCorrelatividad);
    }
}
