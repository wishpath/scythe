package org.sa;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.WorkerDTO;
import org.sa.b_storage.Board;
import org.sa.enums.Faction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainGame {
  public static void main(String[] args) {
    //player draws Faction card and Enlist card
    //TODO: create Enlist card and place in playerDTO constructor
    PlayerDTO player = new PlayerDTO(Faction.GREEN);

    //player picks where to place workers
    List<WorkerDTO> workers = new ArrayList<>();
    for (int i = 0; i < player.faction.initialWorkersCount; i++) {
      Set<TileDTO> nearHomeTiles = Board.getNonNullNeighborsNotSelf(player.faction.home);
      //TODO: player should pick tile but for now we take the first one in the set
      workers.add(new WorkerDTO(nearHomeTiles.iterator().next()));
    }
    player.initialiseWorkers(workers);
  }
}