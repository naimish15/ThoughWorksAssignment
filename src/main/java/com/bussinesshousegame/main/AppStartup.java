package com.bussinesshousegame.main;

import com.bussinesshousegame.enums.CellType;
import com.bussinesshousegame.model.Cell;
import com.bussinesshousegame.model.GameBoard;
import com.bussinesshousegame.model.Player;
import com.bussinesshousegame.processor.PlayerMovementOperatoins;
import com.bussinesshousegame.service.BussinessHouseServices;
import com.bussinesshousegame.serviceImpl.BussinessHouseServicesImpl;

import java.util.*;

public class AppStartup {

    //Assumptions:
    //Bank has infinite money

    static BussinessHouseServices bussinessHouseServices = new BussinessHouseServicesImpl();

    public static void main(String[] args) {

        String boardCellValues = "E,E,J,H,E,T,J,T,E,E,H,J,T,H,E,E,J,H,E,T,J,T,E,E,H,J,T,H,J,E,E,J,H,E,T,J,T,E,E,H,J,T,E,H,E";
        GameBoard gameBoard = bussinessHouseServices.setupBoard(boardCellValues);
        List<Cell> gameBoardCells = gameBoard.getCellList();
        List<Player> players = bussinessHouseServices.setupPlayers(3);
        PlayerMovementOperatoins playerMovementOperatoins = new PlayerMovementOperatoins();

        //10 turns for each player
        for (int i = 1; i <= 10; i++) {
            for (Player player : players) {
                int diceRollNumber = bussinessHouseServices.diceValue(i, player.getPlayerId());
                int targetCellPosition = diceRollNumber + player.getCurrentPosition();

                //Handle circular nature of gameboard
                if (targetCellPosition > 45) {
                    targetCellPosition = targetCellPosition - 45;
                }

                playerMovementOperatoins.cellOperation(player, gameBoardCells, targetCellPosition);
            }
        }

        //Calculate player money
        HashMap<Player, Integer> playerWorthMap = getPlayersWorth(players);
        LinkedHashMap<Player, Integer> sortedPlayerMap = getsortPlayerList(playerWorthMap);

        //Print players worth in decending order
        for (Map.Entry<Player, Integer> entry : sortedPlayerMap.entrySet()) {
            System.out.println(entry.getKey().getPlayerName()+ " has total worth "+entry.getValue());
        }

    }

    public static HashMap<Player, Integer> getPlayersWorth(List<Player> playersList) {
        HashMap<Player, Integer> playersWorhMap = new HashMap<Player, Integer>();
        for(Player player: playersList){
            int playerWorth = player.getAccountBalance() + getAssetAmount(player);
            playersWorhMap.put(player, playerWorth);
        }
        return playersWorhMap;
    }

    public static int getAssetAmount(Player player) {
        return ((CellType.H.getValue()) * (player.getOwnedHotels().size()));
    }

    public static LinkedHashMap<Player, Integer> getsortPlayerList(HashMap<Player, Integer> playersWorthMap) {
        List<Map.Entry<Player, Integer>> playerList = new LinkedList<Map.Entry<Player, Integer>>(playersWorthMap.entrySet());

        Collections.sort(playerList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<Player, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Player, Integer> entry : playerList)
        {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
