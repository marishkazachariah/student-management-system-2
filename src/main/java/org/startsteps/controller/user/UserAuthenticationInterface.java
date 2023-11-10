package org.startsteps.controller.user;

import org.startsteps.model.user.User;

public interface UserAuthenticationInterface {
    boolean register(User user);
    boolean login(String username, String password);
}
