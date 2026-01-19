package org.sa.b_storage;

import org.sa.DTO.TileDTO;
import org.sa.enums.ResourceProduction;

public class Board {
  private final TileDTO center;

  public Board() {
    // Center tile
    center = new TileDTO(ResourceProduction.NONE, false, false);
    center.markCenter();

    // Neighbors
    TileDTO northEast = new TileDTO(ResourceProduction.OIL, false, false);
    TileDTO east      = new TileDTO(ResourceProduction.NONE, true, false);
    TileDTO southEast = new TileDTO(ResourceProduction.WOOD, false, false);
    TileDTO southWest = new TileDTO(ResourceProduction.NONE, true, false);
    TileDTO west      = new TileDTO(ResourceProduction.ORE, false, false);
    TileDTO northWest = new TileDTO(ResourceProduction.NONE, true, false);

    // Link center ↔ neighbors
    setNeighboursBiDirectional(center, TileDTO.NORTH_EAST, northEast);
    setNeighboursBiDirectional(center, TileDTO.EAST, east);
    setNeighboursBiDirectional(center, TileDTO.SOUTH_EAST, southEast);
    setNeighboursBiDirectional(center, TileDTO.SOUTH_WEST, southWest);
    setNeighboursBiDirectional(center, TileDTO.WEST, west);
    setNeighboursBiDirectional(center, TileDTO.NORTH_WEST, northWest);

    // Link neighbors to each other (around center)
    setNeighboursBiDirectional(northEast, TileDTO.SOUTH_EAST, east);
    setNeighboursBiDirectional(east,      TileDTO.SOUTH_WEST, southEast);
    setNeighboursBiDirectional(southEast, TileDTO.WEST, southWest);
    setNeighboursBiDirectional(southWest, TileDTO.NORTH_WEST, west);
    setNeighboursBiDirectional(west,      TileDTO.NORTH_EAST, northWest);
    setNeighboursBiDirectional(northWest, TileDTO.EAST, northEast);
  }

  private void setNeighboursBiDirectional(TileDTO tile, int direction, TileDTO neighbour) {
    tile.setNeighbour(direction, neighbour);
    int opposite = (direction + 3) % 6; // flat-topped opposite
    neighbour.setNeighbour(opposite, tile);
  }

  public TileDTO getCenter() { return center; }
}



