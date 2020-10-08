package de.dhbwka.java.exercise.exam.SoederMemory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryGame {
    private int rows;
    private int cols;
    private List<Player> players;
    private boolean isBlankRequired;

    private List<MemoryImages.MemoryImage> memoryImages;
    private Player activePlayer;

    public MemoryGame(List<Player> players,List<MemoryImages.MemoryImage> memoryImages,int rows, int cols ) throws MemoryException {

        if (players.size()<2){
            throw new MemoryException("At least two players required");
        }
        int cardamount=rows*cols;

        isBlankRequired=cardamount%2!=0;

        if (cardamount>memoryImages.size()*2){
            throw new MemoryException("Too few images available");
        }


        this.rows = rows;
        this.cols = cols;
        this.players = players;
        Collections.shuffle(memoryImages);
        this.memoryImages = memoryImages.subList(0,cardamount/2);

    }

    public boolean isBlankRequired() {
        return isBlankRequired;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
    public void nextPlayer(){
        int currindex=players.indexOf(activePlayer);
        if (currindex==-1){
            activePlayer=players.get(0);
            activePlayer.setStatus(Player.PlayerStatus.ACTIVE);
        }
        else {

            activePlayer.setStatus(Player.PlayerStatus.WAITING);
            if (currindex+1 >= players.size()) {
                currindex = 0;
            } else {
                currindex++;
            }
            activePlayer = players.get(currindex);
            activePlayer.setStatus(Player.PlayerStatus.ACTIVE);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<MemoryImages.MemoryImage> getMemoryImages() {
        return memoryImages;
    }
}