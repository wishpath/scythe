package org.sa;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.WorkerDTO;
import org.sa.enums.Faction;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    PlayerDTO player = new PlayerDTO(Faction.GREEN);

    //player picks where to place workers
    List<WorkerDTO> workers = new ArrayList<>();
    for (int i = 0; i < player.faction.initialWorkersCount; i++) {
      //TODO: player should pick tile but for now we take the first one in the list
      workers.add(new WorkerDTO(player.faction.nextToHomeTiles.getFirst()));
    }
    player.initialiseWorkers(workers);
    System.out.println("Let's play Scythe");
  }
}