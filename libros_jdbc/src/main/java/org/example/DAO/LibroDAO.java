package org.example.DAO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
import org.example.model.Libro;

public class LibroDAO {
    private final DataSource ds;

    public LibroDAO(DataSource ds) {
        if (ds == null) throw new IllegalArgumentException("DataSource nulo");
        this.ds = ds;
    }

    public List<Libro> listarLibros() throws SQLException {

        List<Libro> out = new ArrayList<>();
        String sql = "SELECT id, titulo, anio_publicacion, genero, autor_id FROM libros";

        try (Connection cn = ds.getConnection();

             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                Libro libro = new Libro(
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("isbn"),
                        rs.getInt("anio_publicacion"),
                        rs.getString("genero")
                );
                out.add(libro);
            }
        }
        return out;
    }
}