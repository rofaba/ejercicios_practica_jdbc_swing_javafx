package org.example.dao;

import org.example.config.HibernateUtil;
import org.example.modelo.Alumno;
import org.hibernate.Session;

import java.util.List;

public class AlumnoDao {
    public void saveAlumno(Alumno alumno) {
        // Implementación para guardar un alumno

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void deleteAlumno(Alumno alumno) {
        // Implementación para eliminar un alumno

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
public void updateAlumno(Alumno alumno) {
        // Implementación para actualizar un alumno

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(alumno);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public Alumno getAlumnoById(Long id) {
        // Implementación para obtener un alumno por ID
        Alumno alumno = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            alumno = session.get(Alumno.class, id);
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumno;
}
public List<Alumno> getAllAlumnos() {
        // Implementación para obtener todos los alumnos
        List<Alumno> alumnos = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            alumnos = session.createQuery("from Alumno", Alumno.class).list();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}
