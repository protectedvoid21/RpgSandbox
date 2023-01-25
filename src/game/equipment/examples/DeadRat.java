package game.equipment.examples;

import game.equipment.DisposableItem;

public class DeadRat extends DisposableItem {
    public DeadRat(String name, int usageCount) {
        super(name, usageCount);
        description = "Ah yes. We are in Wrocław";
    }
}
