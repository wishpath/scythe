package org.sa;

import org.sa.enums.IntResourceType;
import org.sa.faction_mat.FactionMat;
import org.sa.faction_mat.Left_EnlistOneTimeReward.Left_EnlistOneTimeReward;
import org.sa.faction_mat.RightBottom_MechDeployAbility.RightBottom_MechDeployAbility;
import org.sa.faction_mat.RightMid_FactionInitialBonus.RightMid_FactionInitialBonus;
import org.sa.faction_mat.RightTop_FactionAbility.RightTop_FactionAbility;
import org.sa.grid.TileDTO;
import org.sa.locatable.locatable.*;
import org.sa.locatable.movable.Movable;
import org.sa.locatable.movable.WorkerDTO;
import org.sa.mission.MissionCard;
import org.sa.player_mat.PlayerMatDTO;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE_TopPart_ActionSpace;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPartType;
import org.sa.player_mat.neighbor_bonus.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerDTO {


  public FactionMat factionMat;
  public int score = 0; //TODO start using (update after each player each move)
  public TYPE_TopPart_ActionSpace previousActionSpace = null; // defined by top action //TODO use
  public boolean isEndOfTurn = true; //should be false during turn
  public boolean isRightAfterMove = false; //should be a short period when the top action was move

  /**-------------- COMBAT CARDS -------------------------------------------------------------------------------------*/
  public List<Integer> playerCombatCards = new ArrayList<>();
  public void addCombatCard(int amount) {
    for (int i = 0; i < amount; i++) playerCombatCards.add(CardPool.drawAttackCard());
  }
  public void removePickedCombatCard(Integer pickedCombatCard) {
    playerCombatCards.remove(pickedCombatCard);
  }
  /**-------------- MISSION CARDS ------------------------------------------------------------------------------------*/
  public List<MissionCard> playerMissionCards = new ArrayList<>();
  public void addMissionCard(int amount) {
    for (int i = 0; i < amount; i++) playerMissionCards.add(CardPool.drawMissionCard());
  }
  public void removePickedMissionCard(MissionCard pickedMissionCard) {
    playerMissionCards.remove(pickedMissionCard);
  }
  /**-------------- INT RESOURCE -------------------------------------------------------------------------------------*/
  public Map<IntResourceType, Integer> intResourceMap = new EnumMap<>(Map.of(
    IntResourceType.HEARTS, 0,
    IntResourceType.COINS, 0,
    IntResourceType.ATTACK, 0
  ));

  public void deltaIntResource(IntResourceType resourceType, int amountDelta) {
    Integer initialQuantity = intResourceMap.get(resourceType);
    if (amountDelta < 0 && initialQuantity < (-1 * amountDelta)) throw new IllegalArgumentException("cannot spend more than we have");
    intResourceMap.put(resourceType, initialQuantity + amountDelta);
  }

  /**-------------- PLAYER MAT ---------------------------------------------------------------------------------------*/
  public PlayerMatDTO playerMat;
  // contains action spaces
    //top
    //bottom
      //neighbor stuff

  /**-------------- NEIGHBOR BONUS (PLAYER MAT) ----------------------------------------------------------------------*/
  //bonus gets enabled by users ENLIST //bonus gets triggered by any bottom action of a neighbor
  public Map<BottomPartType, NeighborBonus> triggerBottomAction_neighborBonusChange = new EnumMap<>(Map.of(
    BottomPartType.UPGRADE, new NeighborBonus__getAttack__UPGRADE(),
    BottomPartType.DEPLOY,  new NeighborBonus__getCoin__DEPLOY(),
    BottomPartType.BUILD,   new NeighborBonus__getHearts__BUILD(),
    BottomPartType.ENLIST,  new NeighborBonus__getAttackCard__ENLIST()
  ));

  /**-------------- BOARD ITEMS --------------------------------------------------------------------------------------*/
  public List<Locatable> locatables = new ArrayList<>(); //includes placed at home movables

  public List<Movable> getPlacedMovables() {
    //includes placed at home
    return locatables.stream().filter(Movable.class::isInstance).map(Movable.class::cast).toList();
  }
  public List<WorkerDTO> getPlacedWorkers() {
    //includes placed at home
    return locatables.stream().filter(WorkerDTO.class::isInstance).map(WorkerDTO.class::cast).toList();
  }
  public Map<TileDTO, Integer> getProducingTiles() {
    return getPlacedWorkers().stream()
        .filter(workerDTO -> workerDTO.location.tileType.producesResourceType != null)
        .collect(Collectors.groupingBy(WorkerDTO::getLocation, Collectors.summingInt(worker -> 1)));
  }
  public List<TokenDTO> getPlacedTokens() {
    return locatables.stream().filter(TokenDTO.class::isInstance).map(TokenDTO.class::cast).toList();
  }
  public List<BuildingDTO> getPlacedBuildings() {
    return locatables.stream().filter(BuildingDTO.class::isInstance).map(BuildingDTO.class::cast).toList();
  }
  //called when player chooses to do top action: if building is built, player gets some bonus
  //this map is updated by BottomPart_Build
  //building type is also attached in each TopPart
  public boolean isBuilt(BuildingType type) {
    return getPlacedBuildings().stream().anyMatch(building -> building.buildingType == type);
  }
  public void buildBuilding(BuildingType type, TileDTO location) {
    if (isBuilt(type)) throw new IllegalStateException(type + " is already built." );
    BuildingDTO buildingDTO = new BuildingDTO(type, location);
    locatables.add(buildingDTO);
  }

  public List<LocatableResourceDTO> getLocatableResources(LocatableResourceType type) {
    return locatables.stream().filter(LocatableResourceDTO.class::isInstance)
        .map(LocatableResourceDTO.class::cast).filter(resource -> resource.locatableResourceType == type).toList();
  }

  public int getAmountOfLocatableResource(LocatableResourceType type) {
    return getLocatableResources(type).size();
  }

  public void addLocatableResource(LocatableResourceType resourceType, int amount, TileDTO tile) {
    //TODO: implement
    if (amount < 0) throw new IllegalArgumentException("amount should be possitive");
    //delta should be >= 0
  }

  public void payLocatableResource(LocatableResourceType locatableResourceType, int currentDelta) {
    //TODO: implement
    if (currentDelta < 0) throw new IllegalArgumentException("currentDelta should be possitive");
    //delta should be >= 0
  }

  /**-------------- FACTION MAT --------------------------------------------------------------------------------------*/
  //FACTION ABILITIES (ALWAYS ACTIVE AFTER FACTION IS ASSIGNED) | MECH ABILITIES (UNLOCKED SEQUENTIALLY VIA DEPLOY)
  public int GREEN_ALBION_flagTokenPool_exalt = 0; //Clan Albion gets 4 / placed AFTER character moved on tile where he landed // decrease this pool after a token is place//TODO: apply to character (Movable) method moveTo

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
  public List<RightBottom_MechDeployAbility> unlockableByMechDeploy_ongoingAbilitiesPool; //right-bottom corner //unused remaining ones //please remove when implemented
  public TileDTO homeTile;
  public final List<Left_EnlistOneTimeReward> unlockableByEnlistAction_factionMat_oneTimeRewardPool; //left-bottom corner //unused remaining ones //please remove when implemented //TODO also implement the related ongoing rewards related to player mat and neighbor actions

  /**-------------- CONSTRUCTOR --------------------------------------------------------------------------------------*/
  public PlayerDTO(PlayerMatDTO playerMat, FactionMat factionMat, List<WorkerDTO> workers) {
    //player mat part
    this.playerMat = playerMat;
    deltaIntResource(IntResourceType.HEARTS, playerMat.initialHearts);
    deltaIntResource(IntResourceType.COINS, playerMat.initialCoins);
    addMissionCard(playerMat.initialMissionCards);

    //factionMat part
    this.factionMat = factionMat;
    for (RightTop_FactionAbility reward : factionMat.initialReward_factionAbility_ongoing) reward.applyToPlayer(this);
    for (RightMid_FactionInitialBonus reward : factionMat.initialBonusToApply_oneTime) reward.applyToPlayer(this);
    this.unlockableByMechDeploy_ongoingAbilitiesPool = factionMat.unlockableByMechDeploy_ongoingAbilitiesPool;
    this.unlockableByEnlistAction_factionMat_oneTimeRewardPool = factionMat.unlockableByEnlistAction_oneTimeRewardPool;
    this.homeTile = factionMat.homeTile;

    //workers part
    this.locatables.addAll(workers);
  }

  public boolean hasTileAToken(TileDTO targetTile) {
    for (TokenDTO tokenDTO : getPlacedTokens())
      if (tokenDTO.getLocation() == targetTile)
        return true;
    return false;
  }
}
