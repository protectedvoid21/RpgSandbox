package game.equipment.examples;

import game.equipment.DisposableItem;
import gui.factories.WarhammerData;

public class DeadRat extends DisposableItem implements WarhammerData {
    public DeadRat(int usageCount) {
        super(usageCount);
        setItemPathPicture(ratPaht);
        workOnEnemy = false;
        description = "Ah yes. We are in Wrocław";
    }
}
