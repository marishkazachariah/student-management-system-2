package org.startsteps.application;

import org.startsteps.controller.cli.CLI;
import org.startsteps.controller.user.UserAuthentication;
import org.startsteps.controller.user.UserAuthenticationInterface;
import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

public class Application {
    public void run() {
        CLI cli = new CLI();
        cli.runCLI();
    }
}
