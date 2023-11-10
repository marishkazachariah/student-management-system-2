package org.startsteps.controller;

import org.startsteps.model.User;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractUserManager implements UserManagerInterface {
    protected Map<String, User> userDatabase;

    protected AbstractUserManager() {
        this.userDatabase = new HashMap<>();
    }
}
