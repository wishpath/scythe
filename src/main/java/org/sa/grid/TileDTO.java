package org.sa.grid;

import org.sa.placeable.locatable.Locatable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class TileDTO {
  public final TileType tileType;
  public boolean isTunnel = false;
  public final EnumSet<DirectionType> rivers = EnumSet.noneOf(DirectionType.class);
  public final int row;
  public final int column; //diagonal direction like this: "\"
  public List<Locatable> currentlyPresentLocatables = new ArrayList<>();

  public TileDTO(TileType resource, int row, int column) {
    this.tileType = resource;
    this.row = row;
    this.column = column;
  }

  public TileDTO markAsTunnel() {
    isTunnel = true;
    return this;
  }

  public TileDTO setRivers(DirectionType... directions) {
    for (DirectionType d : directions) rivers.add(d);
    return this;
  }

  public boolean hasRiverInTheDirection(DirectionType direction) {
    return rivers.contains(direction);
  }
}