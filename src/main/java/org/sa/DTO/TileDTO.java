package org.sa.DTO;

import org.sa.enums.Direction;
import org.sa.enums.TileType;

import java.util.EnumSet;

public class TileDTO {
  public final TileType tileType;
  public boolean isTunnel = false;
  public final EnumSet<Direction> rivers = EnumSet.noneOf(Direction.class);
  public final int row;
  public final int column; //diagonal direction like this: "\"

  public TileDTO(TileType resource, int row, int column) {
    this.tileType = resource;
    this.row = row;
    this.column = column;
  }

  public TileDTO markAsTunnel() {
    isTunnel = true;
    return this;
  }

  public TileDTO setRivers(Direction... directions) {
    for (Direction d : directions) rivers.add(d);
    return this;
  }
}