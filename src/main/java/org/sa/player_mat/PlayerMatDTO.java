package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE_TopPart_ActionSpace;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayerMatDTO {

  public final PlayerMatType type;
  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final ActionSpaceDTO[] actionSpaces_leftToRight;
  public final Map<TYPE_TopPart_ActionSpace, ActionSpaceDTO> actionSpaceType_actionSpaceDTO;

  public PlayerMatDTO(
      PlayerMatType playerMatType,
      int initialHearts,
      int initialCoins,
      int initialMissionCards,
      ActionSpaceDTO[] actionSpaces_leftToRight
  ) {
    this.type = playerMatType;
    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.actionSpaces_leftToRight = actionSpaces_leftToRight;
    this.actionSpaceType_actionSpaceDTO = Arrays
        .stream(actionSpaces_leftToRight)
        .collect(Collectors.toMap(
            actionSpaceDTO -> actionSpaceDTO.tYPE____TopPart__ActionSpace,
            actionSpaceDTO -> actionSpaceDTO,
            (a, b) -> { throw new IllegalStateException("Duplicate action space type: " + a.tYPE____TopPart__ActionSpace); }
        ));
  }
}
