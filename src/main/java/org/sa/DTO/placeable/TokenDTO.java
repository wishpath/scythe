package org.sa.DTO.placeable;

import org.sa.DTO.PlayerDTO;
import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.enums.FactionMat;

/** this can only belong to Albion faction (GREEN) */
public class TokenDTO implements Locatable {
  public TileDTO location; // where the token is placed

  public TokenDTO(PlayerDTO playerDTO, Movable character) {
    if (!playerDTO.isRightAfterMove) throw new IllegalStateException("Token should only be paced right after a MOVE");
    if (!character.isCharacter()) throw new IllegalArgumentException("Only after CHARACTER move, a token can be place");
    if (playerDTO.factionMat != FactionMat.GREEN) throw new IllegalStateException("Tokens are only available for Albion faction (green)");
    this.location = character.getLocation();
  }

  @Override
  public TileDTO getLocation() {
    return location;
  }
}
