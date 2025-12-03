package org.example.modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nombre;
    Integer Edad;

    @ManyToOne
    @JoinColumn(name = "curso_id")   // FK en tabla alumnos
    private Curso curso;


    public Alumno() {
    }
    public Alumno(String nombre, Integer edad) {
        this.nombre = nombre;
        Edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
