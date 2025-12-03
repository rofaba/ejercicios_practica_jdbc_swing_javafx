package org.example.service;

import org.example.dao.AlumnoDao;
import org.example.dao.CursoDao;
import org.example.modelo.Alumno;
import org.example.modelo.Curso;

import java.util.List;

public class EscuelaService {
    AlumnoDao alumnoDao;
    CursoDao cursoDao;

    public EscuelaService() {
        this.alumnoDao = new AlumnoDao();
        this.cursoDao = new CursoDao();
    }

    public void crearAlumno(String nombre, int edad, Curso curso) {

        Alumno alumno = new Alumno(nombre, edad);

        alumno.setCurso(curso);
        curso.getAlumnos().add(alumno);

        alumnoDao.saveAlumno(alumno);
    }


    public Curso crearCurso(String nombre, String descripcion) throws Exception {
        Curso c = new Curso(nombre, descripcion);
        cursoDao.saveCurso(c);
        System.out.println("Curso guardado: " + c.getNombre());
        return c;
    }

    public void listarAlumnos() {
        List<Alumno> alumnos = alumnoDao.getAllAlumnos();
        System.out.println("\nListado de alumnos:");
        for (Alumno a : alumnos) {
            System.out.println(a.getNombre() + " " + a.getNombre() + " - " + a.getEdad());
        }
    }

    public void listarCursos() {
        List<Curso> cursos = cursoDao.getAllCursos();
        System.out.println("\nListado de cursos:");
        for(Curso c : cursos) {
            System.out.println("Curso: " + c.getNombre() + " - Descripción: " + c.getDescripcion());
            System.out.println("Alumnos inscritos:");
            for(Alumno a : c.getAlumnos()) {
                System.out.println(" - " + a.getNombre() + ", Edad: " + a.getEdad());
            }
        }
    }
    public Alumno matricularAlumnoEnCurso(Curso curso, String nombre, int edad) {
        Alumno a = new Alumno(nombre, edad);

        a.setCurso(curso);               // lado N
        curso.getAlumnos().add(a);       // lado 1 (opcional pero recomendable)

        alumnoDao.saveAlumno(a);
        System.out.println("Alumno guardado: " + a.getNombre());
        return a;
    }
}
