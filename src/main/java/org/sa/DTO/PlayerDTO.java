package org.sa.DTO;

import org.sa.DTO.placeable.BuildingDTO;
import org.sa.DTO.placeable.Locatable;
import org.sa.DTO.placeable.TokenDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.DTO.placeable.movable.WorkerDTO;
import org.sa.b_storage.CardPool;
import org.sa.enums.FactionMat;
import org.sa.enums.player_mat_enum.ActionTop;
import org.sa.enums.player_mat_enum.BuildingType;
import org.sa.enums.player_mat_enum.PlayerMat;
import org.sa.mission.MissionCard;
import org.sa.state_change_bonus_reward_ability.StateChange;
import org.sa.state_change_bonus_reward_ability.enlistable_reward.*;

import java.util.*;

public class PlayerDTO {

  public PlayerMat playerMat; //contains: home, name (faction name)
  public FactionMat factionMat;
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
  public ActionTop previousActionSpace = null; // defined by top action //TODO use
  public boolean isEndOfTurn = true; //should be false during turn
  public boolean isRightAfterMove = false; //should be a short period when the top action was move

  /**-------------- PLAYER MAT ---------------------------------------------------------------------------------------*/
  //PLAYER MAT PART (ongoing) (state if enabled or not) //TODO: map to what
  public boolean getsRewardedByNeighborAction_UPGRADE_getsAttack = false;
  public boolean getsRewardedByNeighborAction_DEPLOY_getsCoin = false;
  public boolean getsRewardedByNeighborAction_BUILD_getsHeart = false;
  public boolean getsRewardedByNeighborAction_ENLIST_getsAttackCard = false;

  //PLAYER MAT triggers to enable
  public EnlistableReward[] ongoingBonuses_EnlistableRewards_triggeredByNeighbor = new EnlistableReward[] {
      new EnlistableReward_AttackPlusOne_triggeredByNeighbor_UPGRADE(),
      new EnlistableReward_CoinPlusOne_triggeredByNeighbor_DEPLOY(),
      new EnlistableReward_HeartsPlusOne_triggeredByNeighbor_BUILD(),
      new EnlistableReward_AttackCardPlusOne_triggeredByNeighbor_ENLIST()};

  /**-------------- FACTION MAT --------------------------------------------------------------------------------------*/
  //FACTION ABILITIES (ALWAYS ACTIVE AFTER FACTION IS ASSIGNED) | MECH ABILITIES (UNLOCKED SEQUENTIALLY VIA DEPLOY)
  public int GREEN_ALBION_flagTokenPool_exalt = 0; //Clan Albion gets 4 / placed AFTER character moved on tile where he landed // decrease this pool after a token is place//TODO: apply to character (Movable) method moveTo
  public List<TokenDTO> placed_tokens = new ArrayList<>();
  public boolean GREEN_ALBION_mechAndCharacter_canCrossRiverToOrFromTunnel_burrow = false;
  public boolean GREEN_ALBION_opponentGetsMinus2AttackBeforeYouAttackHim_sword = false; // before combat where player is attacking, opponent gets -2 points of attack
  public boolean GREEN_ALBION_playerGets2AttackBeforeDefence_shield = false; //before combat where you are defending, player gets 2 points of attack
  public boolean GREEN_ALBION_mechAndCharacter_canMoveToWorkerOrFlagTokenTerritory_rally = false; // allows character or mech to move to any territory where you have a worker or Flag token
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

  //(MECH DEPLOY) ABILITIES FOR CONCRETE FACTION
  public List<StateChange> unlockableByMechDeploy_ongoingAbilitiesPool; //right-bottom corner //unused remaining ones //please remove when implemented
  public TileDTO homeTile;
  public final List<StateChange> unlockableByEnlistAction_factionMat_oneTimeRewardPool; //left-bottom corner //unused remaining ones //please remove when implemented //TODO also implement the related ongoing rewards related to player mat and neighbor actions


  /**-------------- BOARD ITEMS --------------------------------------------------------------------------------------*/
  //List<MoveDTO>
  //player board state: each should have coordinate
  //HeroDTO //initially of board new HeroDTO(null);
  //List<RobotDTO> //initially empty list //mechs can always carry workers
  public List<WorkerDTO> placed_workers;
  public List<Locatable> locatables = new ArrayList<>(); //TODO: idea locatables could be a TRUE list, but all other items — virtual
  public List<Movable> movables = new ArrayList<>();
  public Set<BuildingType> buildingsPool_notBuilt = EnumSet.allOf(BuildingType.class); // to be built and removed from this pool
  public Map<BuildingType, BuildingDTO> buildingsBuilt_presentOnGrid = new HashMap<>(); // presence in this map means presence on grid


  /**-------------- CONSTRUCTOR --------------------------------------------------------------------------------------*/
  public PlayerDTO(PlayerMat playerMat, FactionMat factionMat, List<WorkerDTO> workers) {
    //player mat part
    this.playerMat = playerMat;
    this.factionMat = factionMat;
    this.hearts += playerMat.initialHearts;
    this.coins += playerMat.initialCoins;
    for (int i = 0; i < playerMat.initialMissionCards; i++) {
      missionCards.add(CardPool.drawMissionCard());
    }

    //factionMat part
    for (StateChange reward : factionMat.initialReward_factionAbility_ongoing) reward.applyToPlayer(this);
    for (StateChange reward : factionMat.initialBonusToApply_oneTime) reward.applyToPlayer(this);
    this.unlockableByMechDeploy_ongoingAbilitiesPool = factionMat.unlockableByMechDeploy_ongoingAbilitiesPool;
    this.unlockableByEnlistAction_factionMat_oneTimeRewardPool = factionMat.unlockableByEnlistAction_oneTimeRewardPool;
    this.homeTile = factionMat.homeTile;

    //workers part
    this.placed_workers = workers;
    this.locatables.addAll(workers);
    this.movables.addAll(workers);
  }
}
