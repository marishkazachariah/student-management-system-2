package org.startsteps.controller.user;

import org.startsteps.annotations.MethodMetadata;

public interface UserAuthenticationInterface {
    @MethodMetadata(description = "method to register a user into the system.")
    boolean register();
    @MethodMetadata(description = "method for a user to login the system.")
    boolean login();
}
