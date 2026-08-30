package org.sa.locatable.movable;

import org.sa.PlayerDTO;
import org.sa.grid.TileDTO;

public class FighterDTO implements Movable { // can be either mech or character
  public TileDTO location;
  private boolean isMech;
  private boolean isCharacter;

  public FighterDTO(TileDTO initialLocation, boolean isMech_isNotCharacter) {
    this.location = initialLocation;
    this.isMech = isMech_isNotCharacter;
    this.isCharacter = !isMech_isNotCharacter;

  }

  @Override
  public void moveTo(TileDTO targetTile, PlayerDTO player) {
    location = targetTile;
    //todo: if there's an enemy in the target tile then implement war
  }

  @Override
  public MovableType getMovableType() {
    return null;
  }

  @Override
  public boolean isMech() {
    return isMech;
  }

  @Override
  public boolean isWorker() {
    return false;
  }

  @Override
  public boolean isCharacter() {
    return isCharacter;
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }

  @Override
  public boolean controlsLocation() {
    return true;
  }
}
