package org.sa.player_mat;

import org.sa.player_mat.a_top_parts.enums_and_interfaces.TYPE__TopPart__TopPartChooseActionArray__ActionSpace;
import org.sa.player_mat.a_top_parts.enums_and_interfaces.TopPart;
import org.sa.player_mat.bottom_parts.BottomPart;

//contains state, upgradable, through the game
public class ActionSpaceDTO {

  public TYPE__TopPart__TopPartChooseActionArray__ActionSpace tYPE__TopPart__TopPartChooseActionArray__ActionSpace;
  public TopPart topPartObject;
  public BottomPart bottomPartObject;

  public ActionSpaceDTO(
      TYPE__TopPart__TopPartChooseActionArray__ActionSpace topPart_TYPE__actionSpace_TYPE__chooseActionArray_TYPE,
      TopPart topPartObject, BottomPart bottomPartObject) {

    this.tYPE__TopPart__TopPartChooseActionArray__ActionSpace = topPart_TYPE__actionSpace_TYPE__chooseActionArray_TYPE;
    this.topPartObject = topPartObject;
    this.bottomPartObject = bottomPartObject;
  }
}