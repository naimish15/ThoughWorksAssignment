package com.bussinesshousegame.model;

import com.bussinesshousegame.enums.CellType;

public class Cell {

    private CellType cellType;
    private Hotel hotel;

    public Cell(CellType cellType, Hotel hotel) {
        this.cellType = cellType;
        this.hotel = hotel;
    }

    public Cell(CellType cellType) {
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
