package org.startsteps.controller.user;

import org.startsteps.model.user.User;

public class UserAuthentication extends AbstractUserAuthentication {
    @Override
    public boolean register(User user) {
        if (userDatabase.containsKey(user.getUsername())) {
            System.out.println("Username: " + user.getUsername() + " already exists. Please choose another one.");
            return false;
        } else {
            userDatabase.put(user.getUsername(), user);
            System.out.println("Registration successful.");
            return true;
        }
    }

    @Override
    public boolean login(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }
}
