package org.sa.player_mat;

public class PlayerMatDTO {

  public final PlayerMatType type;
  public final int initialHearts;
  public final int initialCoins;
  public final int initialMissionCards;
  public final ActionSpaceDTO[] actionSpaces;

  public PlayerMatDTO(
      PlayerMatType type,
      int initialHearts,
      int initialCoins,
      int initialMissionCards,
      ActionSpaceDTO[] actionSpaces
  ) {
    this.type = type;
    this.initialHearts = initialHearts;
    this.initialCoins = initialCoins;
    this.initialMissionCards = initialMissionCards;
    this.actionSpaces = actionSpaces;
  }
}
