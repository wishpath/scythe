package org.sa.DTO;

import org.sa.b_storage.CardPool;
import org.sa.enlist.EnlistCard;
import org.sa.enums.FactionBoard;
import org.sa.mission.MissionCard;

import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {

  public FactionBoard factionBoard; //contains: home, name (faction name)
  public int score = 0;
  public int hearts = 0;
  public int coins = 0;
  public int attack = 0;
  public List<Integer> attackCards = new ArrayList<>(); //yellow ones
  public List<MissionCard> missionCards = new ArrayList<>();

  // Clan Albion — Exalt (additional to MOVE):
  // 4 Flag Tokens total. After character movement,
  // may place 1 on the territory where it ended.
  public int flagTokenPool = 0; //Clan Albion / Exalt ability / fixed supply of 4 Flag tokens / 1 token — placed AFTER character moved on tile where he landed
  // Clan Albion — Burrow (additional to MOVE):
  // move across rivers to or from an adjacent tunner territory
  public boolean canCrossRiverToOrFromTunnel = false;
  // Clan Albion — Sword (additional to MOVE):
  // before combat where player is attacking, opponent gets -2 points of attack
  public boolean opponentGetsMinus2AttackBeforeYouAttackHim = false;
  // Clan Albion — Shield (additional to MOVE):
  // before combat where you are defending, player gets 2 points of attack
  public boolean playerGets2AttackBeforeDefence = false;
  // Clan Albion — Rally (additional to MOVE / Enlist card):
  // allows character to move to any territory where you have a worker or Flag token
  public boolean canMoveCharacterToControlledTerritory = false;


  //boardItems
  //List<MoveDTO>
  //player board state: each should have coordinate
  //HeroDTO //initially of board new HeroDTO(null);
  //List<RobotDTO> //initially empty list
  public List<WorkerDTO> workers;

  public boolean isEndOfTurn = true; //TODO: when turn starts, make false temporarily

  public PlayerDTO(FactionBoard faction, EnlistCard enlistCard, List<WorkerDTO> workers) { //should provide ElistCard
    //faction board part
    this.factionBoard = faction;
    this.hearts += faction.initialHearts;
    this.coins += faction.initialCoins;
    for (int i = 0; i < faction.initialMissionCards; i++) {
      missionCards.add(CardPool.drawMissionCard());
    }

    //TODO: enlistCard part

    //workers part
    this.workers = workers;
  }
}
