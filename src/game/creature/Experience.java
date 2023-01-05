package game.creature;

public class Experience {
    private int experience;

    public Experience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public int getLevel() {
        return experience / 1000;
    }

    public void addExperiance(int amount) {
        experience += amount;
    }
}

