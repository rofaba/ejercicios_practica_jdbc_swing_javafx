package org.example.service;

import org.example.dao.ProductoDao;
import org.example.dao.TiendaDao;
import org.example.modelo.Producto;
import org.example.modelo.Tienda;

import java.util.List;

public class BodegaService {

    ProductoDao productoDao = new ProductoDao();
    TiendaDao tiendaDao = new TiendaDao();

    public void registrarProductoEnTienda(Producto p, Long tienda_id) {
        productoDao.registerProductoInTienda(p, tienda_id);
    }
    public void guardarTienda(Tienda t) {
        tiendaDao.saveTienda(t);
    }
    public void eliminarTienda(Tienda t) {
        tiendaDao.deleteTienda(t);
    }
    public void actualizarTienda(Tienda t) {
        tiendaDao.updateTienda(t);
    }
    public void guardarProducto(Producto p) {
        productoDao.saveProducto(p);
    }
    public void eliminarProducto(Producto p) {
        productoDao.deleteProducto(p);
    }
    public void actualizarProducto(Producto p) {
        productoDao.updateProducto(p);
    }
    public List<Tienda> getAllTiendas() {
        return tiendaDao.getAllTiendas();
    }
}
