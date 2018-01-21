package dev.challenge;

public enum URLBases {
    ONE("^(https:\\/\\/)www\\..*"),
    TWO("^(https:\\/\\/).*"),
    THREE("^(http:\\/\\/)www\\..*"),
    FOUR("^(http:\\/\\/).*"),
    FIVE("^(www\\.).*"),
    SIX("^.*");

    private final String text;

    URLBases(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
