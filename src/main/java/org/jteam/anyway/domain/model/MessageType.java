package org.jteam.anyway.domain.model;

public enum MessageType {
    TEXT('T'), VOICE('V');
    private char symbol;

    MessageType(char symbol) {
        this.symbol = symbol;

    }

    public char getSymbol() {
        return symbol;
    }

    public static MessageType from(String value) {
        MessageType result = null;
        char c = value != null && value.length() >= 1 ? value.charAt(0) : '\0';
        if (c == TEXT.symbol) {
            result = MessageType.TEXT;
        } else if (c == VOICE.symbol) {
            result = MessageType.VOICE;
        }
        return result;

    }
}
