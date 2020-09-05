package com.bussinesshousegame.enums;

public enum  CellType {

    J("Jail", 150), T("Treasure", 200), H("Hotel", 200), E("Empty", 0);

    String type;
    int value;

    public int getValue() {
        return value;
    }

    CellType(String type, int value) {
        this.type = type;
        this.value = value;
    }
}
