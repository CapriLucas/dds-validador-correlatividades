import static org.junit.jupiter.api.Assertions.*;

import ar.edu.utn.frba.dds.Alumno;
import ar.edu.utn.frba.dds.Inscripcion;
import ar.edu.utn.frba.dds.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;


public class InscripcionTest {

    private Alumno alumno;
    private Set<Materia> materiasAprobadas;
    private Inscripcion inscripcion;
    private Materia matematicaDiscreta;
    private Materia analisisMatematico;
    private Materia matematicaSuperior;
    private Materia analisisDos;

    @BeforeEach
    public void setUp() {
        // Creamos instancias de las materias
        matematicaDiscreta = new Materia(new HashSet<>());
        analisisMatematico = new Materia(new HashSet<>());
        matematicaSuperior = new Materia(Set.of(analisisMatematico, matematicaDiscreta));
        analisisDos = new Materia(Set.of(analisisMatematico));

        // Creamos un conjunto de materias aprobadas para el alumno
        // Notar que no tiene matematicas discreta
        materiasAprobadas = new HashSet<>();
        materiasAprobadas.add(analisisMatematico);

        // Creamos un alumno con las materias aprobadas
        alumno = new Alumno(materiasAprobadas);
    }

    @Test
    public void testAprobadaTodasCorrelativasAprobadas() {
        // Creamos un conjunto de materias para la inscripción
        Set<Materia> materiasInscripcion = Set.of(analisisDos);
        inscripcion = new Inscripcion(alumno, materiasInscripcion);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testMateriasSinCorrelativas() {
        // Creamos un conjunto de materias para la inscripción
        Set<Materia> materiasInscripcion = Set.of(matematicaDiscreta);
        inscripcion = new Inscripcion(alumno, materiasInscripcion);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testDesaprobadaAlgunaCorrelativaNoAprobada() {
        // Creamos un conjunto de materias para la inscripción
        // Agregamos una materia que el alumno no ha aprobado
        Set<Materia> materiasInscripcion = Set.of(analisisDos, matematicaSuperior);
        inscripcion = new Inscripcion(alumno, materiasInscripcion);
        assertFalse(inscripcion.aprobada());
    }
}