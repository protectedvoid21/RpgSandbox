package game.equipment.examples;

import controllers.audio.WarhammerEnumAudio;
import game.equipment.DisposableItem;
import gui.factories.WarhammerData;

public class DeadRat extends DisposableItem implements WarhammerData {
    public DeadRat(int usageCount) {
        super(usageCount);
        enumAudio = WarhammerEnumAudio.RAT;
        setItemPathPicture(ratPaht);
        workOnEnemy = false;
        description = "Ah yes. We are in Wrocław";
    }
}
