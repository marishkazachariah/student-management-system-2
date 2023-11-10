package org.startsteps.controller.user;

import org.startsteps.model.user.User;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractUserAuthentication implements UserAuthenticationInterface {
    protected Map<String, User> userDatabase;

    protected AbstractUserAuthentication() {
        this.userDatabase = new HashMap<>();
    }
}
