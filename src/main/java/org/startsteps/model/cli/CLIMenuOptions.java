package org.startsteps.model.cli;

public enum CLIMenuOptions {
    REGISTER(1),
    LOGIN(2),
    STUDENT_INFORMATION(3),
    COURSE_MANAGEMENT(4),
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