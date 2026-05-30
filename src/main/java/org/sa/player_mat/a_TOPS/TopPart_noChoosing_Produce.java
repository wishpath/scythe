package org.sa.player_mat.a_TOPS;

import org.sa.enums.BuildingType;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TYPE_TopPart_TopActionChooseArray_ActionSpace;
import org.sa.player_mat.a_TOPS.enums_and_interfaces.TopPart;
import org.sa.player_mat.a_TOPS.upgradable_state_change_top.interfaces.UpgradableStateChange_Top;
import org.sa.state_change_bonus_reward_ability.cost_upgradable.UpgradableCost;

public class TopPart_noChoosing_Produce implements TopPart {
  private TYPE_TopPart_TopActionChooseArray_ActionSpace TOP_PART_TYPE__NO_CHOOSE__PRODUCE = TYPE_TopPart_TopActionChooseArray_ActionSpace.NO_CHOOSE__PRODUCE;
  private UpgradableCost SPECIAL_PRODUCE_COST = new UpgradableCost_SpecialProduceCost(,);
  private UpgradableStateChange_Top[] NO_CHOOSING_SIZE1ARRAY__PRODUCE = new UpgradableStateChange_Top[] {
      new UpgradableStateChange_Top_Poduce_Decideable(2, 3)
  };
  private BuildingType MILL = BuildingType.MILL;

  @Override
  public UpgradableCost getCost() {
    return this.SPECIAL_PRODUCE_COST;
  }

  @Override
  public TYPE_TopPart_TopActionChooseArray_ActionSpace getTopPartType() {
    return this.TOP_PART_TYPE__NO_CHOOSE__PRODUCE;
  }

  @Override
  public BuildingType getBuildingType() {
    return this.MILL;
  }

  @Override
  public UpgradableStateChange_Top[] getTopPartChoosableActions() {
    return NO_CHOOSING_SIZE1ARRAY__PRODUCE;
  }
}
