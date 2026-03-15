package org.sa;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.b_storage.Grid;
import org.sa.b_storage.CardPool;
import org.sa.enums.FactionMat_EnlistCard;
import org.sa.enums.PlayerMat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerDecisions {
  public static void main(String[] args) {
    //player draws Faction Mat (color)
    FactionMat_EnlistCard factionMat = CardPool.drawEnlistCard();

    //player draws Player Mat (not connected to faction)
    PlayerMat playerMat = CardPool.drawFactionBoard();

    //player chooses where to place workers
    List<WorkerDTO> workers = new ArrayList<>(factionMat.initialWorkersCount);
    for (int i = 0; i < factionMat.initialWorkersCount; i++) {
      Set<TileDTO> nearHomeTiles = Grid.getNonNullNeighborsNotSelf(factionMat.home);
      workers.add(new WorkerDTO(nearHomeTiles.iterator().next())); //TODO: player should pick for each
    }

    PlayerDTO player = new PlayerDTO(playerMat, factionMat, workers);

    //someone starts the game and there comes turn for the player
    player.isEndOfTurn = false;
  }
}