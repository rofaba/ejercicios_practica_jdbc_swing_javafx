package org.example;

import org.example.modelo.Alumno;
import org.example.modelo.Curso;
import org.example.service.EscuelaService;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws Exception {

        //guardar los alumnos y cursos en la BD
        EscuelaService service = new EscuelaService();

        Curso c1 = service.crearCurso("Matemáticas", "Curso de matemáticas básicas");
        Curso c2 = service.crearCurso("Historia", "Curso de historia Mundial");
        Curso c3 = service.crearCurso("Ciencias", "Curso de ciencias naturales");

        service.crearAlumno("Juan Pérez", 16, c1);
        service.crearAlumno("Ana Gómez", 15, c2);
        service.crearAlumno("Luis Rodríguez", 17, c3);

        service.listarCursos();
    }

}