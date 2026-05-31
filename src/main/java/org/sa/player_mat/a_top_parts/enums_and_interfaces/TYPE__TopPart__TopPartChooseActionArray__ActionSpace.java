package org.sa.player_mat.a_top_parts.enums_and_interfaces;

 /**
 * A few things defined by this same type:
 * 1. action space
 * 2. top part choose action array
 * 3. top part
 * */
public enum TYPE__TopPart__TopPartChooseActionArray__ActionSpace {
  CHOOSE__MOVE__GAIN_COINS, // Move units on the board and possibly engage in combat
  NO_CHOOSE__PRODUCE,   // Produce resources from territories with workers
  CHOOSE__TRADE__GAIN_HEARTS,     // Trade coins for any two resources
  BOLSTER,   // Increase Power or draw combat cards
}