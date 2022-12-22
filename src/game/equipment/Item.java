package game.equipment;

import game.interfaces.Statistics;

public abstract class Item {

      protected Statistics playerStats;

      public Item(Statistics stats) {
            playerStats = stats;
      }
      public abstract void use();
      public abstract boolean isValid();
}
