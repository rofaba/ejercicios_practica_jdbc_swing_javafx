package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO(db.getDataSource());

        User newUser1 = new User("Pato Donaldo", "pdonaldo@example.com");
        User newUser2 = new User("Mickey Mouser", "mmouser@example.com");

        try {

            Long id1 = userDAO.createUser(newUser1);
            Long id2 = userDAO.createUser(newUser2);

            System.out.println("Created User ID 1: " + id1);
            System.out.println("Created User ID 2: " + id2);

            User retrievedUser1 = userDAO.getUserById(id1);
            User retrievedUser2 = userDAO.getUserById(id2);

            System.out.println("Retrieved User 1: " + retrievedUser1);
            System.out.println("Retrieved User 2: " + retrievedUser2);

            List<User> allUsers = userDAO.getAllUsers();
            System.out.println("All Users:");
            for (User user : allUsers) {
                System.out.println(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}