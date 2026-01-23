package org.sa.DTO;

import org.sa.enums.Faction;

import java.util.List;

public class PlayerDTO {

  //faction part
  public Faction faction;
  public int score = 0;
  public int hearts = 0;
  public int coins = 0;
  public int missionCards = 0; //should be List<MissionDTO> or something mission should be enum

  //List<MoveDTO>

  //elist card part
  public int attack = 0;
  public int attackCards = 0; //should be List<

  //player board state: each should have coordinate
  //HeroDTO
  //List<RobotDTO>
  public int workerCount = 2;
  //List<WorkerDTO>


  public PlayerDTO(Faction faction) { //should provide ElistCard
    this.faction = faction;
    this.hearts = faction.initialHearts;
    this.coins = faction.initialCoins;

    this.missionCards = faction.initialMissionCards;
    //here pick 2 random missionCards from the CardPool and populate new field List<MissionDTO> or anything that indicates concrete missions

  }

  public void initialiseWorkers(List<WorkerDTO> workers) {
  }
}
