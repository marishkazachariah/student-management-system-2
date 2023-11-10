package org.startsteps.controller.user;

import org.startsteps.model.user.User;

public interface UserAuthenticationInterface {
    boolean register();
    boolean login();
}
