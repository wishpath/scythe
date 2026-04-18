package org.sa.DTO.top_state_change_decision;

import org.sa.DTO.TileDTO;
import org.sa.DTO.placeable.movable.Movable;
import org.sa.enums.TopStateChangeDecision_TYPE_ENUM;
import java.util.List;
import java.util.Objects;


public final class SingleMoveDecisionOutcome implements TopStateChangeDecisionOutcome {
  private final List<Movable> singleMoveMovablesGroup;
  private final TileDTO targetTile;
  public TopStateChangeDecision_TYPE_ENUM type = TopStateChangeDecision_TYPE_ENUM.MOVE;

  public SingleMoveDecisionOutcome(
      List<Movable> singleMoveMovablesGroup,
      TileDTO targetTile) {
    this.singleMoveMovablesGroup = singleMoveMovablesGroup;
    this.targetTile = targetTile;
  }

  public List<Movable> singleMoveMovablesGroup() {
    return singleMoveMovablesGroup;
  }

  public TileDTO targetTile() {
    return targetTile;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (SingleMoveDecisionOutcome) obj;
    return Objects.equals(this.singleMoveMovablesGroup, that.singleMoveMovablesGroup) &&
        Objects.equals(this.targetTile, that.targetTile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(singleMoveMovablesGroup, targetTile);
  }

  @Override
  public String toString() {
    return "SingleMoveDecisionOutcome[" +
        "singleMoveMovablesGroup=" + singleMoveMovablesGroup + ", " +
        "targetTile=" + targetTile + ']';
  }


  @Override
  public TopStateChangeDecision_TYPE_ENUM type() {
    return this.type;
  }
}
