package game.equipment;

import gui.factories.WarhammerData;

public class Mount extends ManyUsageItem implements WarhammerData {
    private int speed;

    public Mount(String name, int speed) {
        super(name);
        this.speed =speed;

        setItemPathPicture(mountBasicPath);
    }

    public int getSpeed() {
        return speed;
    }
}
