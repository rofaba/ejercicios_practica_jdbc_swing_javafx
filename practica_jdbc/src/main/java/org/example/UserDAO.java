package org.example;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDAO  {

    private final DataSource ds;

    public UserDAO(DataSource ds) {
        this.ds = ds;
    }



    public Long createUser(User user) throws Exception {
        String sql="INSERT INTO users (name, email) VALUES (?, ?)";
        try(Connection con = ds.getConnection();

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());


        ps.executeUpdate();

        try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }

   }


    public User getUserById(Long id) throws Exception {
        String sql="SELECT id, name, email FROM users WHERE id = ?";
        try(Connection con = ds.getConnection();

            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Long userId = rs.getLong("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    return new User(userId, name, email);
                }
            }
        }
        return null;
    }


    public java.util.List<User> getAllUsers() throws Exception {
        String sql="SELECT id, name, email FROM users";

        try(Connection con = ds.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            List<User> users = new java.util.ArrayList<>();
            while (rs.next()) {
                Long userId = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                users.add(new User(userId, name, email));
            }
            return users;
        }

    }
    public Optional<User> findUserByEmail(String email) throws Exception {
        String sql = "SELECT id, name, email FROM users WHERE email = ?";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) { //execute, es un select
                if (rs.next()) {
                    Long userId = rs.getLong("id");
                    String name = rs.getString("name");
                    String userEmail = rs.getString("email");
                    return Optional.of(new User(userId, name, userEmail));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public boolean updateUserName(Long id, String newName) throws Exception {
        String sql = "UPDATE users SET name = ? WHERE id = ?";

        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setLong(2, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

}
