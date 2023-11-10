package org.startsteps.model.cli;

import org.startsteps.annotations.FieldMetadata;

public enum CLIMenuOptions {
    @FieldMetadata(description = "Option to register")
    REGISTER(1),
    @FieldMetadata(description = "Option to login")
    LOGIN(2),
    @FieldMetadata(description = "Option to view student information")
    STUDENT_INFORMATION(3),
    @FieldMetadata(description = "Option to access course management")
    COURSE_MANAGEMENT(4),
    @FieldMetadata(description = "Option to exit program")
    EXIT_SYSTEM(5);

    private final int value;

    CLIMenuOptions(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CLIMenuOptions fromInt(int option) {
        for (CLIMenuOptions menuOption : CLIMenuOptions.values()) {
            if (menuOption.getValue() == option) {
                return menuOption;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + option);
    }
}