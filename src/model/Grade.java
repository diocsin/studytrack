package model;

public enum Grade {
    A, B, C, D, F;

    public int getValue() {
        return switch (this) {
            case A -> 5;
            case B -> 4;
            case C -> 3;
            case D -> 2;
            case F -> 1;
        };
    }
}
