package org.sa.player_mat;

public class PlayerMatDTO {

  public final PlayerMatType type;
  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final ActionSpaceDTO[] actionSpaces_leftToRight;

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
  }
}
