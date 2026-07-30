package com.airtribe.learntrack.util;

public class InputValidator {

    private InputValidator() {
    }

    public static boolean isValidEmail(String email) {

        return email != null
                && email.contains("@")
                && email.contains(".");
    }

    public static boolean isValidName(String name) {

        return name != null && !name.trim().isEmpty();
    }
}