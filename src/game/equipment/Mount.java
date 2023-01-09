package game.equipment;

public class Mount extends ManyUsageItem{
    private int speed;

    public Mount(String name, int speed) {
        super(name);
        this.speed =speed;
    }

    public int getSpeed() {
        return speed;
    }
}
