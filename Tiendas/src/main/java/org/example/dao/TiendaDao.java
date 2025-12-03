package org.example.dao;

import org.example.modelo.Tienda;
import org.hibernate.Transaction;

import java.util.List;

public class TiendaDao {
    public void saveTienda(Tienda t) {
        // Implementación para guardar una tienda
        Transaction tx = null;
        try (var session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteTienda(Tienda t) {
        // Implementación para eliminar una tienda
        Transaction tx = null;
        try (var session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void updateTienda(Tienda t) {
        // Implementación para actualizar una tienda
        Transaction tx = null;
        try (var session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }
    public List<Tienda> getAllTiendas() {
        try (var session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Tienda", Tienda.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


