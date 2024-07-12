package main.java.assignment1.enums;

public enum ItemType {
    RAW,
    MANUFACTURED,
    IMPORTED;

    public static ItemType fromString(String type) {
        return ItemType.valueOf(type.toUpperCase());
    }
}
