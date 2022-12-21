package com.example.idc;

public enum Operators {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODULO("%");

    private String icon;

    Operators(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
