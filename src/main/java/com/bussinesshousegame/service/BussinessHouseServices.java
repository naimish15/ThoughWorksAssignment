package com.bussinesshousegame.service;

import com.bussinesshousegame.model.GameBoard;
import com.bussinesshousegame.model.Player;

import java.util.List;

public interface BussinessHouseServices {

    public GameBoard setupBoard(String cellpositionInput);
    public List<Player> setupPlayers(int numberOfPlayers);
    public int diceValue(int turn, int playerId);

}
