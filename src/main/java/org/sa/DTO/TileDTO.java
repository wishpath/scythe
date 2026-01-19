package org.sa.DTO;

import org.sa.enums.ResourceProduction;

public class TileDTO {
  // Flat-topped hex directions (clockwise starting top-right)
  public static final int NORTH_EAST = 0;
  public static final int EAST       = 1;
  public static final int SOUTH_EAST = 2;
  public static final int SOUTH_WEST = 3;
  public static final int WEST       = 4;
  public static final int NORTH_WEST = 5;

  private final ResourceProduction resource;
  private final boolean isWater;
  private final boolean isTunnel;
  private boolean isCenter = false;
  private TileDTO[] neighbours;

  public TileDTO(ResourceProduction resource, boolean isWater, boolean isTunnel) {
    this.resource = resource;
    this.isWater = isWater;
    this.isTunnel = isTunnel;
    this.neighbours = new TileDTO[6]; // null for missing neighbors at edges
  }

  public ResourceProduction getResource() { return resource; }
  public boolean isTunnel() { return isTunnel; }
  public boolean isCenter() { return isCenter; }
  public boolean isWater() { return isWater; }
  public void markCenter() { isCenter = true; }
  public void setNeighbour(int direction, TileDTO neighbour) { this.neighbours[direction] = neighbour; }
}