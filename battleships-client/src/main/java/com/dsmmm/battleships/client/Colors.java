package com.dsmmm.battleships.client;

enum Colors {
    BLUE("blue"), YELLOW("yellow");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
