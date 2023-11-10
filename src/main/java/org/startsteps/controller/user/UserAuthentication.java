package org.startsteps.controller.user;

import org.startsteps.controller.cli.CLI;
import org.startsteps.model.roles.Admin;
import org.startsteps.model.roles.Teacher;
import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.util.Map;
import java.util.Scanner;

public class UserAuthentication extends AbstractUserAuthentication {
    private Scanner scanner;
    private CLI cli;

    public UserAuthentication(Map<String, User> userDatabase) {
        super(userDatabase);
        scanner = new Scanner(System.in);
        cli = new CLI();
    }

    @Override
    protected UserRole getUserRole(UserRole userRole) {
        return null;
    }

    @Override
    protected Map<String, User> getUserDatabase() {
        return userDatabase;
    }

    @Override
    public boolean register() {
        while (true) {
            System.out.println("Enter a username:");
            String username = scanner.next();
            boolean isUsernameTaken = false;
            if (userDatabase.containsKey(username)) {
                System.out.println("Username already exists. Please choose a different one.");
                isUsernameTaken = true;
                break;
            }
            if (isUsernameTaken) {
                continue;
            }

            System.out.println("Enter a password:");
            String password = scanner.next();
            if (password.length() < 6) {
                System.out.println("Password is too short. Please type a password longer than 6 characters.");
                continue;
            }

            System.out.println("Select from the following roles:");
            for (UserRole role : UserRole.values()) {
                System.out.println(role.ordinal() + 1 + ". " + role.name());
            }
            int roleChoice = scanner.nextInt();
            if (roleChoice < 1 || roleChoice > UserRole.values().length) {
                System.out.println("Invalid role choice.");
                continue;
            }

            UserRole selectedRole = UserRole.values()[roleChoice - 1];

            User newUser = new User(username, password, selectedRole);
            newUser.setPassword(password);
            userDatabase.put(username, newUser);

            UserDataManager userDataManager = new UserDataManager();
            userDataManager.saveUserData(newUser);
            System.out.println("Registration successful.");
            return true;
        }
        cli.runCLI();
        return false;
    }

    @Override
    public boolean login() {
        UserDataManager userDataManager = new UserDataManager();
        userDataManager.loadUserData(userDatabase);

        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        boolean loginSuccessful = false;

        if (userDatabase.containsKey(username) && userDatabase.get(username).getPassword().equals(password)) {
            System.out.println("Login successful");
            System.out.println("ROLE: " + userDatabase.get(username).getRole());
            switch (userDatabase.get(username).getRole()) {
                case ADMIN -> {
                    Admin admin = new Admin(userDatabase.get(username).getUsername(), userDatabase.get(username).getPassword());
                    admin.displayRoleSpecificMenu();
                }
                case STUDENT -> userDatabase.get(username).displayRoleSpecificMenu();
                case TEACHER -> {
                    Teacher teacher = new Teacher(userDatabase.get(username).getUsername(), userDatabase.get(username).getPassword());
                    teacher.displayRoleSpecificMenu();
                }
                default -> System.err.println("Invalid user role");
            }
            loginSuccessful = true;
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }
}
