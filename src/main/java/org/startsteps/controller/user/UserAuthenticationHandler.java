package org.startsteps.controller.user;

import org.startsteps.controller.cli.CLI;
import org.startsteps.model.roles.Admin;
import org.startsteps.model.roles.Teacher;
import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.util.Scanner;

public class UserAuthenticationHandler {
    private final AbstractUserAuthentication authentication;

    public UserAuthenticationHandler(AbstractUserAuthentication authentication) {
        this.authentication = authentication;
    }

    public boolean registerUser(Scanner scanner, CLI cli) {
        while (true) {
            System.out.println("Enter a username:");
            String username = scanner.next();

            if (authentication.getUserDatabase().containsKey(username)) {
                System.out.println("Username already exists. Please choose a different one.");
                break;
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
            authentication.getUserDatabase().put(username, newUser);

            UserDataManager userDataManager = new UserDataManager();
            userDataManager.saveUserData(newUser);
            System.out.println("Registration successful.");
            return true;
        }
        cli.runCLI();
        return false;
    }

    public boolean loginUser(Scanner scanner, CLI cli) {
        UserDataManager userDataManager = new UserDataManager();
        userDataManager.loadUserData(authentication.getUserDatabase());

        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();

        if (authentication.getUserDatabase().containsKey(username)
                && authentication.getUserDatabase().get(username).getPassword().equals(password)) {

            System.out.println("Login successful");
            System.out.println("ROLE: " + authentication.getUserDatabase().get(username).getRole());
            switch (authentication.getUserDatabase().get(username).getRole()) {
                case ADMIN -> {
                    Admin admin = new Admin(authentication.getUserDatabase().get(username).getUsername(),
                            authentication.getUserDatabase().get(username).getPassword());
                    admin.displayRoleSpecificMenu();
                }
                case STUDENT -> authentication.getUserDatabase().get(username).displayRoleSpecificMenu();
                case TEACHER -> {
                    Teacher teacher = new Teacher(authentication.getUserDatabase().get(username).getUsername(),
                            authentication.getUserDatabase().get(username).getPassword());
                    teacher.displayRoleSpecificMenu();
                }
                default -> System.err.println("Invalid user role");
            }
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            cli.runCLI();
            return false;
        }
    }
}
