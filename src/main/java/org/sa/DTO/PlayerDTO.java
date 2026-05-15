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
import org.sa.state_change_bonus_reward_ability.StateChange;
import org.sa.state_change_bonus_reward_ability.enlistable_reward.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerDTO {

  public PlayerMat playerMat; //contains: home, name (faction name)
  public int score = 0; //TODO start using (update after each player each move)
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
  public ActionTop previousAction = null; //TODO use
  public EnlistableReward[] ongoingBonuses_EnlistableRewards_triggeredByNeighbor = new EnlistableReward[] { //TODO: move to player board state when created // maybe player dto can have both pools and state
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

  //FACTION ABILITIES (ALWAYS ACTIVE AFTER FACTION IS ASSIGNED) | MECH ABILITIES (UNLOCKED SEQUENTIALLY VIA DEPLOY)
  public int GREEN_ALBION_flagTokenPool_exalt = 0; //Clan Albion gets 4 / placed AFTER character moved on tile where he landed //TODO: apply to character (Movable) method moveTo
  public boolean GREEN_ALBION_canCrossRiverToOrFromTunnel_burrow = false;
  public boolean GREEN_ALBION_opponentGetsMinus2AttackBeforeYouAttackHim_sword = false; // before combat where player is attacking, opponent gets -2 points of attack
  public boolean GREEN_ALBION_playerGets2AttackBeforeDefence_shield = false; //before combat where you are defending, player gets 2 points of attack
  public boolean GREEN_ALBION_canMoveCharacterToWorkerOrFlagTokenTerritory_rally = false; // allows character to move to any territory where you have a worker or Flag token
  public boolean BLACK_SAXONY_unlimitedCombatStars_dominate = false; // no limit on combat victory stars; may complete both objective cards
  public boolean BLACK_SAXONY_canCrossRiverOntoForestOrMountain_riverwalk = false; // character and mechs can move across rivers onto Forests and Mountains
  public boolean BLACK_SAXONY_mountainsAndTunnelsAreAdjacent_underpass = false; // for character and mech movement, controlled Mountains and all Tunnels (including Mine) are considered adjacent
  public boolean BLACK_SAXONY_opponentLoses2PowerBeforeCombatOnTunnelOrMine_disarm = false; // before combat on Tunnel or Mine territory, opponent loses 2 power once per combat
  public boolean BLACK_SAXONY_characterAndMechsGetPlus1Move_speed = false; // character and mechs may move 1 additional territory per Move action
  public boolean BLUE_NORDIC_workersCanCrossRivers_swim = false; // workers may move across rivers onto any terrain except lakes
  public boolean BLUE_NORDIC_canCrossRiverOntoForestOrMountain_riverwalk = false; // character and mechs can move across rivers onto Forests and Mountains
  public boolean BLUE_NORDIC_canMoveToOrFromLakes_seaworthy = false; // character and mechs may move to and from lakes and retreat onto adjacent lakes
  public boolean BLUE_NORDIC_canPay1PowerToMakeOpponentLose2PowerBeforeCombat_artillery = false; // before combat, may pay 1 power to make opponent lose 2 power once per combat
  public boolean BLUE_NORDIC_characterAndMechsGetPlus1Move_speed = false; // character and mechs may move 1 additional territory per Move action
  public boolean PURPLE_TOGAWA_canPlaceArmedTrapAfterCharacterMovement_maifuku = false; // after ending character movement, may place an armed Trap token on that territory
  public boolean PURPLE_TOGAWA_canCrossRiverOncePerMoveAction_toka = false; // once per move action, either character or 1 mech may move across a river
  public boolean PURPLE_TOGAWA_canMoveToOrFromLakesAndPlayAdditionalCombatCardThere_suiton = false; // character and mechs may move to and from lakes; in combat on a lake, may play 1 additional combat card once per combat
  public boolean PURPLE_TOGAWA_playerGets2PowerBeforeCombatWhenHavingExactly1UnitAnd0Workers_ronin = false; // before combat, if you have exactly 1 unit and 0 workers, gain 2 power
  public boolean PURPLE_TOGAWA_canMoveToAnyTrapTokenAndRearmDisarmedTrap_shinobi = false; // character and mechs may move to any territory with your Trap token regardless of distance; if movement ends on a disarmed Trap token, may arm it
  public boolean RED_RUSVIET_canChooseSameActionSpaceEveryTurn_relentless = false; // may choose the same section on the player mat as on the previous turn
  public boolean RED_RUSVIET_canCrossRiverOntoFarmOrVillage_riverwalk = false; // character and mechs can move across rivers onto Farms and Villages
  public boolean RED_RUSVIET_controlledVillagesAndFactoryAreAdjacent_township = false; // for Move actions, controlled Villages and the Factory are considered adjacent for character and mechs
  public boolean RED_RUSVIET_canPlayAdditionalCombatCardWhenHavingWorkerInCombat_peoplesArmy = false; // in combat where you have at least 1 worker, may play 1 additional combat card; still requires a character or mech in combat
  public boolean RED_RUSVIET_characterAndMechsGetPlus1Move_speed = false; // character and mechs may move 1 additional territory per Move action
  public boolean WHITE_POLANIA_pickUpUpTo2OptionsPerEncounterCard_meander = false;
  public boolean WHITE_POLANIA_canCrossRiverOntoVillagesAndMountains_riverwalk = false;
  public boolean WHITE_POLANIA_canMoveOnLake_canMoveToAnyLake_submerge = false;
  public boolean WHITE_POLANIA_notLoosesPopularityWhenForcesWorkersToRetreat_camaraderie = false;
  public boolean WHITE_POLANIA_characterAndMechsGetPlus1Move_speed = false; // character and mechs may move 1 additional territory per Move action
  public boolean YELLOW_CRIMEA_canTradeCombatCardsForAnyResouce_coercion = false;
  public boolean YELLOW_CRIMEA_canCrossRiverOntoFarmsAndTundra_riverwalk = false;
  public boolean YELLOW_CRIMEA_moveToOrFrom_ownOrInactiveFactionHome_wayfare = false;
  public boolean YELLOW_CRIMEA_beforeCombatSteal1OpponentsCombatCard_scout = false;
  public boolean YELLOW_CRIMEA_characterAndMechsGetPlus1Move_speed = false; // character and mechs may move 1 additional territory per Move action



  //boardItems
  //List<MoveDTO>
  //player board state: each should have coordinate
  //HeroDTO //initially of board new HeroDTO(null);
  //List<RobotDTO> //initially empty list //mechs can always carry workers
  public List<WorkerDTO> workers;
  public List<Locatable> locatables = new ArrayList<>();
  public List<Movable> movables = new ArrayList<>();

  public boolean isEndOfTurn = true; //TODO: when turn starts, make false temporarily

  public PlayerDTO(PlayerMat playerMat, FactionMat factionMat, List<WorkerDTO> workers) {
    //player mat part
    this.playerMat = playerMat;
    this.hearts += playerMat.initialHearts;
    this.coins += playerMat.initialCoins;
    for (int i = 0; i < playerMat.initialMissionCards; i++) {
      missionCards.add(CardPool.drawMissionCard());
    }

    //factionMat part
    for (StateChange reward : factionMat.initialReward_factionAbility_ongoing) reward.applyToPlayer(this);
    for (StateChange reward : factionMat.initialBonusToApply_oneTime) reward.applyToPlayer(this);
    this.playerEnlistState = new PlayerEnlistStateDTO(factionMat);

    //workers part
    this.workers = workers;
    this.locatables.addAll(workers);
    this.movables.addAll(workers);
  }
}
