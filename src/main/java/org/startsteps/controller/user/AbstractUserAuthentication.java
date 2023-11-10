package org.startsteps.controller.user;

import org.startsteps.model.user.User;
import org.startsteps.model.user.UserRole;

import java.util.Map;

abstract class AbstractUserAuthentication implements UserAuthenticationInterface {
    protected Map<String, User> userDatabase;

    protected AbstractUserAuthentication(Map<String, User> userDatabase) {
        this.userDatabase = userDatabase;
    }
    protected abstract UserRole getUserRole(UserRole userRole);
    protected abstract Map<String, User> getUserDatabase();
}
