package org.sa.DTO.top_state_change_decision;

import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;

import java.util.List;

public record MoveDecision(List<Group> groups) implements TopStateChangeDecision {

  public record Group(List<Movable> movables, TileDTO targetTile) {
  }
}