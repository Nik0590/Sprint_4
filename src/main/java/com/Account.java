package com;

public class Account {

    private final String name;

    int WhiteSpace;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() throws NullPointerException {

        String trimmedName = name.trim();
        boolean isNumeric = trimmedName.matches(".*\\d.*");

        if (trimmedName.length() >= 3 && trimmedName.length() <= 19) {
            if (!isNumeric) {
                if (!trimmedName.isBlank()) {
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
            }
            return false;
        }
        return false;
    }
}
