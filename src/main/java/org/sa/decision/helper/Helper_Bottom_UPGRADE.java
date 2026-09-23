package org.sa.decision.helper;

import org.sa.PlayerDTO;
import org.sa.player_mat.a_top_parts.top_part_upgradable_action.interfaces.TopPartUpgradableAction;
import org.sa.player_mat.bottom_parts.bottom_part_cost.BottomPartUpgradableCost;
import org.sa.player_mat.bottom_parts.enums_and_interfaces.BottomPart;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper_Bottom_UPGRADE {
  public static void applyBottomActionUPGRADE(BottomPart pickedBottomPartObject, PlayerDTO player) {
    // get list of all TopPartUpgradableAction across all action spaces. filter out fully upgraded ones
    List<TopPartUpgradableAction> topPartUpgradableActions = player.playerMat.actionSpaceType_actionSpaceDTO.values().stream()
        .flatMap(actionSpace -> Arrays.stream(actionSpace.topPartObject.getTopPartChoosableActions()))
        .filter(TopPartUpgradableAction::canUpgrade)
        .collect(Collectors.toList());
    if (topPartUpgradableActions.isEmpty()) {
      System.out.println("Nothing to upgrade. Nothing got upgraded.");
      return;
    }
    TopPartUpgradableAction userPickedUpgradableAction = topPartUpgradableActions.get(0); // TODO: user picks
    userPickedUpgradableAction.upgrade_increaseTheReward(); //upgrades

    // get list of all getBottomPart_UpgradableCost() across all action spaces. filter out fully upgraded ones.
    List<BottomPartUpgradableCost> bottomPartUpgradableCosts = player.playerMat.actionSpaceType_actionSpaceDTO.values().stream()
        .map(actionSpace -> actionSpace.bottomPartObject.getBottomPart_UpgradableCost())
        .filter(BottomPartUpgradableCost::canUpgrade)
        .collect(Collectors.toList());
    if (bottomPartUpgradableCosts.isEmpty()) throw new IllegalStateException("Top and Bottom upgrades mismatch");
    BottomPartUpgradableCost userPickedUpgradableCost = bottomPartUpgradableCosts.get(0); // TODO: user picks
    userPickedUpgradableCost.upgrade_lowerTheCost(); //upgrades
  }

}
