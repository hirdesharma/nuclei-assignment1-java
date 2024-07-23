package main.java.assignment1.enums;

import main.java.assignment1.exceptions.InvalidArgument;

public enum ItemType {
    RAW,
    MANUFACTURED,
    IMPORTED;

    public static ItemType fromString(String type) {
        if (type == null) {
            throw new InvalidArgument("Item type cannot be null");
        }
        try {
            return ItemType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidArgument("Invalid item type: " + type);
        }
    }
}
