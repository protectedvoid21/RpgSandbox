package game.generals;

public class Effect {

    private String name;
    boolean active;
    int timeLeft;

    public Effect(){
        name = "bleding";
        active = false;
        timeLeft = 0;
    }

    public Effect(String name, boolean active, int timeLeft){
        this.name = name;
        this.active = active;
        this.timeLeft = timeLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
}
