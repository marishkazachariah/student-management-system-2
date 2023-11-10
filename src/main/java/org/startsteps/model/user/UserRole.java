package org.startsteps.model.user;

import org.startsteps.annotations.FieldMetadata;

public enum UserRole {
    @FieldMetadata(description = "Administrator role")
    ADMIN("Admin"),
    @FieldMetadata(description = "Teacher role")
    TEACHER("Teacher"),
    @FieldMetadata(description = "Student role")
    STUDENT("Student");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

