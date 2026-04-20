package org.sa.DTO;

import org.sa.DTO.placeable.BuildingDTO;
import org.sa.DTO.placeable.Locatable;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.b_storage.CardPool;
import org.sa.enums.ActionTop;
import org.sa.enums.Building;
import org.sa.enums.FactionMat;
import org.sa.enums.PlayerMat;
import org.sa.mission.MissionCard;
import org.sa.reward.StateChange;
import org.sa.reward.enlistable_reward.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerDTO {

  public PlayerMat playerMat; //contains: home, name (faction name)
  public int score = 0;
  public int hearts = 0;
  public int coins = 0;
  public int attack = 0;
  public int oil = 0;
  public int wood = 0;
  public int food = 0;
  public int metal = 0;
  public List<Integer> attackCards = new ArrayList<>(); //yellow ones
  public List<MissionCard> missionCards = new ArrayList<>();
  public PlayerEnlistStateDTO playerEnlistState; //contains: ability and bonus pool, available for choosing during enlist action
  public ActionTop previousAction = null;
  public EnlistableReward[] ongoingBonuses_EnlistableRewards = new EnlistableReward[] { //TODO: move to player board state when created
      new EnlistableReward_AttackPlusOne(),
      new EnlistableReward_CoinPlusOne(),
      new EnlistableReward_HeartsPlusOne(),
      new EnlistableReward_AttackCardPlusOne()};
  public Map<Building, BuildingDTO> buildings = Map.of( //TODO: consider moving to player board state when created
      Building.MILL, new BuildingDTO(Building.MILL),
      Building.MONUMENT, new BuildingDTO(Building.MONUMENT),
      Building.ARMORY, new BuildingDTO(Building.ARMORY),
      Building.MINE, new BuildingDTO(Building.MINE)
  );

  // Clan Albion — Exalt (additional to MOVE):
  // 4 Flag Tokens total. After character movement,
  // may place 1 on the territory where it ended.
  public int flagTokenPool = 0; //Clan Albion / Exalt ability / fixed supply of 4 Flag tokens / 1 token — placed AFTER character moved on tile where he landed //TODO: apply to character (Movable) method moveTo
  // Clan Albion — Burrow (additional to MOVE):
  // move across rivers to or from an adjacent tunner territory
  public boolean canCrossRiverToOrFromTunnel = false; //TODO: apply to each Movable method moveTo
  // Clan Albion — Sword (additional to MOVE):
  // before combat where player is attacking, opponent gets -2 points of attack
  public boolean opponentGetsMinus2AttackBeforeYouAttackHim = false; //TODO: apply to attack functionality
  // Clan Albion — Shield (additional to MOVE):
  // before combat where you are defending, player gets 2 points of attack
  public boolean playerGets2AttackBeforeDefence = false; //TODO: apply to defence functionality
  // Clan Albion — Rally (additional to MOVE / Enlist card):
  // allows character to move to any territory where you have a worker or Flag token
  public boolean canMoveCharacterToControlledTerritory = false; //TODO: apply to character (Movable) method moveTo


  //boardItems
  //List<MoveDTO>
  //player board state: each should have coordinate
  //HeroDTO //initially of board new HeroDTO(null);
  //List<RobotDTO> //initially empty list
  public List<WorkerDTO> workers;
  public List<Locatable> locatables = new ArrayList<>();
  public List<Movable> movables = new ArrayList<>();

  public boolean isEndOfTurn = true; //TODO: when turn starts, make false temporarily
  public boolean canMechBringWorkers = false; //TODO: figure out when this turns on

  public PlayerDTO(PlayerMat playerMat, FactionMat factionMat, List<WorkerDTO> workers) {
    //faction board part
    this.playerMat = playerMat;
    this.hearts += playerMat.initialHearts;
    this.coins += playerMat.initialCoins;
    for (int i = 0; i < playerMat.initialMissionCards; i++) {
      missionCards.add(CardPool.drawMissionCard());
    }

    //factionMat part
    for (StateChange reward : factionMat.initialReward) reward.applyToPlayer(this);
    for (StateChange reward : factionMat.initialBonusToApply) reward.applyToPlayer(this);
    this.playerEnlistState = new PlayerEnlistStateDTO(factionMat);

    //workers part
    this.workers = workers;
    this.locatables.addAll(workers);
    this.movables.addAll(workers);
  }
}
