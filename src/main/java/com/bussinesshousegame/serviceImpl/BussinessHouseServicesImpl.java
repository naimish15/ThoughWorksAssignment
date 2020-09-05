package com.bussinesshousegame.serviceImpl;

import com.bussinesshousegame.enums.CellType;
import com.bussinesshousegame.model.Cell;
import com.bussinesshousegame.model.GameBoard;
import com.bussinesshousegame.model.Hotel;
import com.bussinesshousegame.model.Player;
import com.bussinesshousegame.service.BussinessHouseServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BussinessHouseServicesImpl implements BussinessHouseServices {

    public GameBoard setupBoard(String cellpositionInput) {

        // Sample input
        // String cellpositionInput = "H,E,J,T";
        GameBoard gameBoard = new GameBoard();
        List<Cell> cells = new ArrayList<Cell>();
        List<String> cellListByType = Arrays.asList(cellpositionInput.split(","));

        for (String cellType : cellListByType) {
            if ("H".equals(cellType)) {
                cells.add(new Cell(CellType.H, new Hotel()));
            } else if ("E".equals(cellType)) {
                cells.add(new Cell(CellType.E));
            } else if ("J".equals(cellType)) {
                cells.add(new Cell(CellType.J));
            } else if ("T".equals(cellType)){
                cells.add(new Cell(CellType.T));
            } else {
                try {
                    throw new Exception("Invalid Input");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        gameBoard.setCellList(cells);
        return gameBoard;
    }

    public List<Player> setupPlayers(int numberOfPlayers) {

        List<Player> players = new ArrayList<Player>();

        //Create player list
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player-" + i, i, 1000, 0, new ArrayList<Hotel>()));
        }
        return players;
    }

    public int diceValue(int turn, int playerId) {
        /*Random rand = new Random();
        //Generate random number between 0 to 10 and add 2 into it
        return rand.nextInt(11) + 2;*/

        final int totalPlayers = 3;
        final String diceOutputs = "4,4,4,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12,2,3,5,6,7,8,5,11,10,12";
        List<String> diceOutputToArrray = Arrays.asList(diceOutputs.split(","));
        int diceNumber = Integer.parseInt(diceOutputToArrray.get(((turn-1)*totalPlayers)+playerId-1));
        if(!validDiceNumber(diceNumber)) {
            try {
                throw new Exception("Invalid Dice number");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return diceNumber;
    }

    private boolean validDiceNumber(int diceNumber) {
        if (diceNumber < 2 || diceNumber > 12) {
            return false;
        }
        return true;
    }
}
