package org.startsteps.controller;

import org.startsteps.model.User;

public interface UserManagerInterface {
    boolean registerUser(User user);
    boolean loginUser(String username, String password);
}
