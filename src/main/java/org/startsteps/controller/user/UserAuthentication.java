package org.startsteps.controller.user;

import org.startsteps.controller.cli.CLI;
import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.util.Map;
import java.util.Scanner;

public class UserAuthentication extends AbstractUserAuthentication {
    private final Scanner scanner;
    private final CLI cli;
    private final UserAuthenticationHandler authenticationHandler;

    public UserAuthentication(Map<String, User> userDatabase) {
        super(userDatabase);
        scanner = new Scanner(System.in);
        cli = new CLI();
        authenticationHandler = new UserAuthenticationHandler(this);
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
        return authenticationHandler.registerUser(scanner, cli);
    }

    @Override
    public boolean login() {
        return authenticationHandler.loginUser(scanner, cli);
    }
}
