package org.example;

import org.example.DAO.LibroDAO;
import org.example.data.DataSourceProvider;
import org.example.model.Libro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

public class Main {

    try(conn = DataSourceProvider.get()) {
        System.out.println("Conexion exitosa a la base de datos.");
    } catch (SQLException e) {
        System.out.println("Error al conectar a la base de datos: " + e.getMessage());
    }


    public static void main(String[] args) throws SQLException {
    LibroDAO ld = new LibroDAO();

    System.out.println("Catalogo de Libros");
        LibroDAO libroDAO;
        List<Libro> listado = ld.listarLibros();
        for (Libro libro : listado) {
            System.out.println(libro);
        }




}
}