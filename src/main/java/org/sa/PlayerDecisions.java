package org.sa;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.WorkerDTO;
import org.sa.b_storage.Board;
import org.sa.b_storage.CardPool;
import org.sa.enlist.EnlistCard;
import org.sa.enums.FactionBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerDecisions {
  public static void main(String[] args) {

    //player draws Enlist card
    EnlistCard enlistCard = CardPool.drawEnlistCard();

    //player draws Faction board (color)
    FactionBoard factionBoard = CardPool.drawFactionBoard();
    //Faction board determines a number of workers and player decides where to place them
    List<WorkerDTO> workers = new ArrayList<>(factionBoard.initialWorkersCount);
    for (int i = 0; i < factionBoard.initialWorkersCount; i++) {
      Set<TileDTO> nearHomeTiles = Board.getNonNullNeighborsNotSelf(factionBoard.home);
      //TODO: player should pick
      workers.add(new WorkerDTO(nearHomeTiles.iterator().next()));
    }

    PlayerDTO player = new PlayerDTO(factionBoard, enlistCard, workers);
  }
}