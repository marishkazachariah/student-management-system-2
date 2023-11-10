package org.startsteps.application;

import org.startsteps.controller.UserManager;
import org.startsteps.controller.UserManagerInterface;
import org.startsteps.model.User;
import org.startsteps.model.UserRole;

public class Application {
    public void run() {
        exercise2();
    }

    public static void exercise2() {
        UserManagerInterface userManager = new UserManager();
        User johnnyC = new User("johnny_c", "12345", UserRole.STUDENT);
        User johnnyCDuplicate = new User("johnny_c", "5678", UserRole.STUDENT);

        userManager.registerUser(johnnyC);
        userManager.registerUser(johnnyCDuplicate);
        userManager.loginUser("johnny_c", "12345");
        userManager.loginUser("johnny_c", "wrong-password");
    }
}
