package org.startsteps.controller.cli;

import org.startsteps.controller.user.UserAuthentication;
import org.startsteps.controller.user.UserSession;

import java.util.HashMap;
import java.util.Scanner;

public class CLI {
    public void runCLI() {
        Scanner scanner = new Scanner(System.in);
        CLIManager menuManager = new CLIManager(new UserAuthentication(new HashMap<>()), new UserSession());

        while (menuManager.isRunning()) {
            menuManager.displayMenu();
            menuManager.processInput(scanner);
        }

        scanner.close();
    }
}