package org.startsteps.controller.user;

import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

class UserAuthenticationHandler {
    private final AbstractUserAuthentication authentication;

    public UserAuthenticationHandler(AbstractUserAuthentication authentication) {
        this.authentication = authentication;
    }

    public boolean register(User user) {
        UserDataManager userDataManager = new UserDataManager();
        boolean registrationSuccessful = authentication.register();

        if (registrationSuccessful) {
            userDataManager.saveUserData(user);
        }
        return registrationSuccessful;
    }

    public boolean login() {
        return authentication.login();
    }

    public UserRole getUserRole(UserRole userRole) {
        return authentication.getUserRole(userRole);
    }
}