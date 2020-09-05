package com.bussinesshousegame.model;

import java.util.List;

public class GameBoard {

    private List<Cell> cellList;

    public List<Cell> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cell> cellList) {
        this.cellList = cellList;
    }
}
