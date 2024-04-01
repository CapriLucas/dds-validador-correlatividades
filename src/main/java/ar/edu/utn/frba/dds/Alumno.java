package ar.edu.utn.frba.dds;

import java.util.Set;

public class Alumno {
    private Set<Materia> materiasAprobadas;

    public Alumno(Set<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Boolean cumpleCorrelatividad(Materia materia) {
        Set<Materia> materiasCorrelativas = materia.getMateriasCorrelativas();
        // Verificamos que el alumno haya aprobado todas las materias correlativas
        return materiasAprobadas.containsAll(materiasCorrelativas);
    }
}
