package com.bussinesshousegame.processor;

import com.bussinesshousegame.enums.CellType;
import com.bussinesshousegame.model.Cell;
import com.bussinesshousegame.model.GameBoard;
import com.bussinesshousegame.model.Hotel;
import com.bussinesshousegame.model.Player;

import java.util.List;

public class PlayerMovementOperatoins {

    public static void cellOperation(Player player, List<Cell> boardCells, int nextPosition) {

        //Move player to next position
        player.setCurrentPosition(nextPosition);
        Cell targetCell = boardCells.get(nextPosition-1);
        switch (targetCell.getCellType()) {
            case T:
                player.setAccountBalance(player.getAccountBalance() + CellType.T.getValue());
                break;
            case J:
                player.setAccountBalance(player.getAccountBalance() - CellType.J.getValue());
                break;
            case H:
                Hotel hotel = targetCell.getHotel();
                if(hotel == null){
                    //Throw error
                }
                else if (hotel.getHotelOwner() == null) {
                    buyHotel(hotel, player, boardCells);
                } else {
                    if (hotel.getHotelOwner().getPlayerId() == player.getPlayerId()) {
                        //Player is owner so do nothing
                    } else {
                        payRent(player, hotel.getHotelOwner());
                    }
                }
                break;
            case E:
                //Do nothing
                break;
            default:
                break;
        }
    }

    static void buyHotel(Hotel hotel, Player player, List<Cell> boardCells) {
        if (player.getAccountBalance() >= CellType.H.getValue()) {
            player.setAccountBalance(player.getAccountBalance() - CellType.H.getValue());
            hotel.setHotelOwner(player);
            player.getOwnedHotels().add(hotel);
        } else {
            try {
                throw new Exception(" Insufficient amount in players account to buy hotel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static void payRent(Player player, Player hotelOwner) {
        if (player.getAccountBalance() >= 50) {
            player.setAccountBalance(player.getAccountBalance() - 50);
            hotelOwner.setAccountBalance(hotelOwner.getAccountBalance() + 50);
        } else {
            try {
                throw new Exception(" Insufficient amount in players account to buy hotel");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
