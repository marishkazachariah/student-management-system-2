package org.startsteps.controller.cli;

import org.startsteps.controller.user.UserAuthentication;
import org.startsteps.controller.user.UserSession;
import org.startsteps.model.cli.CLIMenuOptions;

import java.util.InputMismatchException;
import java.util.Scanner;

class CLIManager {
    private boolean running;
    private final UserAuthentication userAuthentication;
    private final UserSession userSession;

    public CLIManager(UserAuthentication userAuthentication, UserSession userSession) {
        this.running = true;
        this.userAuthentication = userAuthentication;
        this.userSession = userSession;
    }

    public void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("Choose from the following options:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Student Management");
        System.out.println("4. Teacher Management");
        System.out.println("5. Quit Program");
    }

    public void processInput(Scanner scanner) {
        try {
            int input = scanner.nextInt();
            CLIMenuOptions menuOption = CLIMenuOptions.fromInt(input);

            switch (menuOption) {
                case REGISTER -> {
                    System.out.println("register user");
                    userAuthentication.register();
                }
                case LOGIN -> {
                    System.out.println("login user");
                    if (userAuthentication.login()) {
                        userSession.setLoggedIn(true);
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Please try again.");
                    }
                }
                case STUDENT_INFORMATION -> {
                    if (userSession.isLoggedIn()) {
                        System.out.println("Student Management!");
                    } else {
                        System.out.println("Please login first.");
                    }
                }
                case COURSE_MANAGEMENT -> {
                    if (userSession.isLoggedIn()) {
                        System.out.println("Teacher Management!");
                    } else {
                        System.out.println("Please login first.");
                    }
                }
                case EXIT_SYSTEM -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Choose another option.");
            scanner.next();
        }
    }

    public boolean isRunning() {
        return running;
    }
}