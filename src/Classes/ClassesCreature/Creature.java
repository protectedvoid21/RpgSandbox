package Classes.ClassesCreature;

abstract public class Creature {

    // statysyki podstawowe są z przedziału 0-100
    private int weaponSkill;
    private int ballisticSkill;
    private int strength;
    private int tougness;
    private int agility;
    private int intelligence;
    private int willPower;
    private int fellowship;

    // statystyki drugożędne
    private int attacks; // ilość ataków możliwych do wykonania
    private int healthpoints;
    private int streangthBonus; // Bonus do obrażen zależny od siły ( SB = strength%10)
    private int tougnessBonus; // Zmniejsza otrzymane obrażenia o swoją wartość. Zależne od odporności (TB = tougness %10)
    private int movement; // ile Pól może przejść w jednej akcji
    private int magic; // ilość kości przy teście rzutu zaklęcia;

    //Stany

    private boolean isBleading;
    private boolean isShocked;
    private boolean isPoisoned;
    private boolean isInFire;

    public Creature(){
        weaponSkill = 30;
        ballisticSkill = 30;
        strength = 30;
        tougness = 30;
        agility = 30;
        intelligence = 30;
        willPower = 30;
        fellowship = 30;

        attacks = 1;
        healthpoints = 12;
        streangthBonus = strength%10;
        tougnessBonus = tougness%10;
        movement = 4;
        magic = 0;
    }








    public int getWeaponSkill() {
        return weaponSkill;
    }

    public void setWeaponSkill(int weaponSkill) {
        this.weaponSkill = weaponSkill;
    }

    public int getBallisticSkill() {
        return ballisticSkill;
    }

    public void setBallisticSkill(int ballisticSkill) {
        this.ballisticSkill = ballisticSkill;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getTougness() {
        return tougness;
    }

    public void setTougness(int tougness) {
        this.tougness = tougness;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWillPower() {
        return willPower;
    }

    public void setWillPower(int willPower) {
        this.willPower = willPower;
    }

    public int getFellowship() {
        return fellowship;
    }

    public void setFellowship(int fellowship) {
        this.fellowship = fellowship;
    }

    public int getAttacks() {
        return attacks;
    }

    public void setAttacks(int attacks) {
        this.attacks = attacks;
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    public int getStreangthBonus() {
        return streangthBonus;
    }

    public void setStreangthBonus(int streangthBonus) {
        this.streangthBonus = streangthBonus;
    }

    public int getTougnessBonus() {
        return tougnessBonus;
    }

    public void setTougnessBonus(int tougnessBonus) {
        this.tougnessBonus = tougnessBonus;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public boolean isBleading() {
        return isBleading;
    }

    public void setBleading(boolean bleading) {
        isBleading = bleading;
    }

    public boolean isShocked() {
        return isShocked;
    }

    public void setShocked(boolean shocked) {
        isShocked = shocked;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }

    public boolean isInFire() {
        return isInFire;
    }

    public void setInFire(boolean inFire) {
        isInFire = inFire;
    }
}
