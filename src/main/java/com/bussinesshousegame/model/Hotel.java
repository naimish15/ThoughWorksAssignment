package com.bussinesshousegame.model;

public class Hotel {

    private int hotelId;
    private Player hotelOwner;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Player getHotelOwner() {
        return hotelOwner;
    }

    public void setHotelOwner(Player hotelOwner) {
        this.hotelOwner = hotelOwner;
    }
}
