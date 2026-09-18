package org.sa.decision.helper;

import org.sa.PlayerDTO;
import org.sa.grid.DirectionType;
import org.sa.grid.Grid;
import org.sa.grid.TileDTO;
import org.sa.grid.TileType;
import org.sa.locatable.locatable.BuildingType;
import org.sa.locatable.locatable.TokenDTO;
import org.sa.locatable.locatable.TradeableResourceDTO;
import org.sa.locatable.movable.Movable;
import org.sa.locatable.movable.WorkerDTO;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.TopPartUpgradableAction_Move_Decideable;

import java.util.*;

public class Helper_MOVE {
  public static void DECIDE_andApply_TopAction_MOVE(TopPartUpgradableAction_Move_Decideable moveAction, PlayerDTO player) {
    int moveCountTotal = moveAction.getCurrentChangeDelta();
    List<Movable> movablesWithValidDestinationsPool = new ArrayList<>(player.getPlacedMovablesWithValidMoveDestinations()); // new list but references same objects

    for (int moveCount = 0; moveCount < moveCountTotal && movablesWithValidDestinationsPool.size() > 0; moveCount++) {
      //decide who moves
      int userPicked_mainMovableIndex = new Random().nextInt(movablesWithValidDestinationsPool.size()); // todo: PLAYER DECIDES main movable
      Movable userPicked_mainMovable = movablesWithValidDestinationsPool.remove(userPicked_mainMovableIndex);
      TileDTO mainMovableLocation = userPicked_mainMovable.getLocation();

      //decide who moves together
      List<Movable> groupOfMovablesDecidedToMove = new ArrayList<>(List.of(userPicked_mainMovable)); //includes main movable
      if (userPicked_mainMovable.isMech()) {
        List<WorkerDTO> workersInMechLocation = player.getWorkersInTile(mainMovableLocation);
        int playerPicked_workersCountToMoveTogether = workersInMechLocation.size();//todo: PLAYER DECIDES how many workers go together
        for (int j = 0; j < playerPicked_workersCountToMoveTogether; j++) {
          Movable worker = workersInMechLocation.get(j);
          groupOfMovablesDecidedToMove.add(worker);
          movablesWithValidDestinationsPool.remove(worker); //might be in this list initialy, but might be not.
        }
      }

      //decide where to move
      Set<TileDTO> possibleTargets = getTilesToMoveTo(userPicked_mainMovable, player); //TODO: get list of available Tiles to go to and PLAYER SHOULD PICK ONE
      if (possibleTargets.size() < 1) throw new IllegalStateException("since we only picked movables with valid destinations, the size of this list should be > 0");

      //move
      TileDTO targetTile = possibleTargets.iterator().next(); //TODO: player picks target tile
      for (Movable movable : groupOfMovablesDecidedToMove) movable.moveTo(targetTile, player); //execute move (considered as one move)

      //carry tradeable resources // !!! this part should stay AFTER move because of "hasMovables" check.
      if (!player.hasLocationAtLeast2Fighters(mainMovableLocation)) {
        if (userPicked_mainMovable.isCharacter() || userPicked_mainMovable.isCharacter() || !player.hasMovables(mainMovableLocation)) { //there are no such rules in the game but let's keep this part simple as this is quite logical
          List<TradeableResourceDTO> resourcesToCarry = player.getTradeableResources(mainMovableLocation);
          for (TradeableResourceDTO resource : resourcesToCarry) resource.carryTo(targetTile);
        }
      }

      //after move effects
      player.isRightAfterMove = true;
      if (player.GREEN_ALBION_flagTokenPool_exalt > 0 && player.isRightAfterMove && userPicked_mainMovable.isCharacter() && !player.hasTileAToken(targetTile)) {
        boolean decidedPlayerToPlaceToken = true; //TODO: player decides
        if (decidedPlayerToPlaceToken) {
          player.locatables.add(new TokenDTO(player, userPicked_mainMovable));
          player.GREEN_ALBION_flagTokenPool_exalt--;
        }
      }
      player.isRightAfterMove = false;

      //fight
      //TODO: fight
      //TODO: when player brings resources to the fight, but looses the fight, will the opponent take re resources?
    }
  }

  public static Set<TileDTO> getTilesToMoveTo(Movable movable, PlayerDTO player) {
    TileDTO tileFrom = movable.getLocation();
    Set<TileDTO> validDestinationTiles = new HashSet<>();

    //deal neighboring tiles
    for (DirectionType direction : DirectionType.values()) { //includes direction Direction.THIS
      TileDTO tileTo = Grid.getNeighborTile_possiblyNull(tileFrom, direction); //possibly self
      if (tileTo == null) continue;
      if (tileTo.tileType.equals(TileType.LAKE)) continue;

      //deal river
      if (tileFrom.hasRiverInTheDirection(direction)) {
        if (player.GREEN_ALBION_mechAndCharacter_canCrossRiverToOrFromTunnel_burrow && (movable.isCharacter() || movable.isMech())) {
          if (tileFrom.isTunnel || tileTo.isTunnel) validDestinationTiles.add(tileTo);
          else continue;
        }
        else continue;
      }
    }

    //deal tunnels/mines
    if (tileFrom.isTunnel || player.hasTileBuilding(tileFrom, BuildingType.MINE)) {
      validDestinationTiles.addAll(Grid.tunnels);
      validDestinationTiles.addAll(player.getPlacedBuildingLocations(BuildingType.MINE));
      validDestinationTiles.remove(tileFrom);
    }

    //deal GREEN_ALBION rally (mech and char move to worker or token)
    if (player.GREEN_ALBION_mechAndCharacter_canMoveToWorkerOrFlagTokenTerritory_rally && (movable.isCharacter() || movable.isMech())) {
      for (TokenDTO token : player.getPlacedTokens()) validDestinationTiles.add(token.getLocation());
      for (WorkerDTO worker : player.getPlacedWorkers()) validDestinationTiles.add(worker.getLocation());
    }

    return validDestinationTiles;
  }
}


//TODO player attributes that might also be important:
//Teleportation and special spatial adjacencies:
//player.BLACK_SAXONY_mountainsAndTunnelsAreAdjacent_underpass;                     // Treats controlled Mountains, Tunnels, and Mine as adjacent
//player.PURPLE_TOGAWA_canMoveToAnyTrapTokenAndRearmDisarmedTrap_shinobi;          // Allows direct move to any tile containing your Trap token
//player.RED_RUSVIET_controlledVillagesAndFactoryAreAdjacent_township;             // Treats controlled Villages and central Factory as adjacent
//player.YELLOW_CRIMEA_moveToOrFrom_ownOrInactiveFactionHome_wayfare;             // Allows move directly to/from your home or inactive faction homes
//River crossing rules based on destination tile terrain:
//player.BLUE_NORDIC_workersCanCrossRivers_swim;                       // Allows workers to cross rivers onto any terrain except lakes
//player.BLACK_SAXONY_canCrossRiverOntoForestOrMountain_riverwalk;     // Cross rivers onto Forest or Mountain tiles
//player.BLUE_NORDIC_canCrossRiverOntoForestOrMountain_riverwalk;     // Cross rivers onto Forest or Mountain tiles
//player.RED_RUSVIET_canCrossRiverOntoFarmOrVillage_riverwalk;         // Cross rivers onto Farm or Village tiles
//player.WHITE_POLANIA_canCrossRiverOntoVillagesAndMountains_riverwalk;// Cross rivers onto Village or Mountain tiles
//player.YELLOW_CRIMEA_canCrossRiverOntoFarmsAndTundra_riverwalk;      // Cross rivers onto Farm or Tundra tiles
//player.PURPLE_TOGAWA_canCrossRiverOncePerMoveAction_toka;            // Limits river crossing to once per move action
//Enables lake tiles as valid move destinations:
//player.BLUE_NORDIC_canMoveToOrFromLakes_seaworthy;                      // Move onto/off lake tiles and retreat onto adjacent lakes
//player.PURPLE_TOGAWA_canMoveToOrFromLakesAndPlayAdditionalCombatCardThere_suiton; // Move onto/off lake tiles
//player.WHITE_POLANIA_canMoveOnLake_canMoveToAnyLake_submerge;            // Move onto/off lakes and move directly between any lake tiles
//Increases unit movement range (expanding the reach of reachable tiles):     // TODO: if moving 2 tiles allowed, both should be completed at once, since attack on moving first tile would prevent from going second tile (additional info: first tile cannot be skipped from action)
//player.BLACK_SAXONY_characterAndMechsGetPlus1Move_speed; // Grants +1 step distance to Character/Mechs
//player.BLUE_NORDIC_characterAndMechsGetPlus1Move_speed;  // Grants +1 step distance to Character/Mechs
//player.RED_RUSVIET_characterAndMechsGetPlus1Move_speed;  // Grants +1 step distance to Character/Mechs
//player.WHITE_POLANIA_characterAndMechsGetPlus1Move_speed;// Grants +1 step distance to Character/Mechs
//player.YELLOW_CRIMEA_characterAndMechsGetPlus1Move_speed; // Grants +1 step distance to Character/Mechs