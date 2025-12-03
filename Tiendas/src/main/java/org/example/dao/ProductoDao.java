package org.example.dao;

import org.example.modelo.Producto;
import org.example.modelo.Tienda;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductoDao {

    public void saveProducto(Producto p) {
        Transaction tx = null;
        try (Session session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProducto(Producto p) {
        Transaction tx = null;
        try (Session session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void updateProducto(Producto p) {
        Transaction tx = null;
        try (Session session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(p);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //registrar un producto en una tienda
    public void registerProductoInTienda(Producto p, Long tienda_id) {
        try (Session session = org.example.config.HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            p.setStore(tienda_id != null ? session.get(Tienda.class, tienda_id) : null);
            session.update(p);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
