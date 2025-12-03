package org.example.dao;

import org.example.config.HibernateUtil;
import org.example.modelo.Curso;
import org.hibernate.Session;

import java.util.List;

public class CursoDao {

    public void saveCurso(Curso curso) {
        // Implementación para guardar un curso
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(curso);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCurso(Curso curso) {
        // Implementación para eliminar un curso
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(curso);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCurso(Curso curso) {
        // Implementación para actualizar un curso
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(curso);
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public Curso getCursoById(Long id) {
        // Implementación para obtener un curso por ID
        Curso curso = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            curso = session.get(Curso.class, id);
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return curso;
    }

    public List<Curso> getAllCursos() {
        // Implementación para obtener todos los cursos
        java.util.List<Curso> cursos = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            cursos = session.createQuery("from Curso", Curso.class).list();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }
}
