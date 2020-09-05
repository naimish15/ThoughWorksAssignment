package com.bussinesshousegame.model;

import java.util.List;

public class Player{

    private String playerName;
    private int playerId;
    private int accountBalance;
    private int currentPosition;
    private List<Hotel> ownedHotels;

    public Player(String playerName, int playerId, int accountBalance, int currentPosition, List<Hotel> ownedHotels) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.accountBalance = accountBalance;
        this.currentPosition = currentPosition;
        this.ownedHotels = ownedHotels;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Hotel> getOwnedHotels() {
        return ownedHotels;
    }

    public void setOwnedHotels(List<Hotel> ownedHotels) {
        this.ownedHotels = ownedHotels;
    }

}
