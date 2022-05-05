package com;

import io.qameta.allure.Step;

public class Account {

    private final String name;

    int WhiteSpace;

    public Account(String name) {
        this.name = name;
    }

    @Step("Проверка текста для эмбоссирования")
    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        }
        String trimmedName = name.trim();
        boolean isNumeric = trimmedName.matches(".*\\d.*");
        return isValidLength(trimmedName) && !isNumeric && !trimmedName.isBlank() && isSpaceOne(trimmedName);
    }

    public boolean isSpaceOne(String trimmedName) {
        for (char tName : trimmedName.toCharArray()) {
            if (Character.isWhitespace(tName)) {
                WhiteSpace += 1;
            }
        }
        if (WhiteSpace != 1) {
            return false;
        }
        return true;
    }

    public boolean isValidLength(String trimmedName) {
        return trimmedName.length() >= 3 && trimmedName.length() <= 19;
    }
}
