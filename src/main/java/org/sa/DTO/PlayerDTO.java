package org.sa.DTO;

import org.sa.enums.Faction;

import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {

  //main
  public Faction faction;
  public int score = 0;
  public int hearts = 0;
  public int coins = 0;
  public int missionCards = 0; //should be List<MissionDTO> or something mission should be enum
  public int attack = 0;
  public List<Integer> attackCards = new ArrayList<>();



  // Clan Albion — Exalt (additional to MOVE):
  // 4 Flag Tokens total. After character movement,
  // may place 1 on the territory where it ended.
  public int flagTokenPool = 0; //Clan Albion / Exalt ability / fixed supply of 4 Flag tokens / 1 token — placed AFTER character moved on tile where he landed


  //boardItems



  //List<MoveDTO>
  //player board state: each should have coordinate
  //HeroDTO //initially of board new HeroDTO(null);
  //List<RobotDTO> //initially empty list
  public List<WorkerDTO> workers;

  public boolean isEndOfTurn = true; //TODO: when turn starts, make false temporarily

  public PlayerDTO(Faction faction) { //should provide ElistCard
    this.faction = faction;
    this.hearts = faction.initialHearts;
    this.coins = faction.initialCoins;

    this.missionCards = faction.initialMissionCards;
    //here pick 2 random missionCards from the CardPool and populate new field List<MissionDTO> or anything that indicates concrete missions

  }

  public void initialiseWorkers(List<WorkerDTO> workers) {
    this.workers = workers;
  }
}
