package org.sa;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.WorkerDTO;
import org.sa.b_storage.Grid;
import org.sa.b_storage.CardPool;
import org.sa.enums.EnlistCard;
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

    //player chooses where to place workers
    List<WorkerDTO> workers = new ArrayList<>(factionBoard.initialWorkersCount);
    for (int i = 0; i < factionBoard.initialWorkersCount; i++) {
      Set<TileDTO> nearHomeTiles = Grid.getNonNullNeighborsNotSelf(factionBoard.home);
      workers.add(new WorkerDTO(nearHomeTiles.iterator().next())); //TODO: player should pick for each
    }

    PlayerDTO player = new PlayerDTO(factionBoard, enlistCard, workers);
  }
}