package ar.edu.utn.frba.dds;

import java.util.Set;

public class Materia {
    private Set<Materia> materiasCorrelativas;

    public Materia(Set<Materia> materiasCorrelativas) {
        this.materiasCorrelativas = materiasCorrelativas;
    }

    public Set<Materia> getMateriasCorrelativas() {
        return materiasCorrelativas;
    }
}
