package game.equipment;

import game.creature.Creature;
import game.interfaceWarhammer.EffectEnum;
import gui.factories.WarhammerData;

import java.util.ArrayList;
import java.util.Random;

public class Weapon extends ManyUsageItem {
    private int damage;
    private int range;
    private int chanceForBleeding;
    private int chanceForPoison;
    private int chanceForFire;
    private int chanceForFreezing;

    public Weapon(String name, int damage, int range) {
        super(name);
        Random random = new Random();
        this.range = range;
        this.damage = damage;
        chanceForBleeding = random.nextInt(101);
        chanceForPoison = random.nextInt(101);
        chanceForFire = random.nextInt(101);
        chanceForFreezing = random.nextInt(101);
    }

    public Weapon(String name, int damage, int range, int bleeding, int poison, int fire, int freezing) {
        super(name);
        this.damage = damage;
        this.range = range;
        chanceForBleeding = bleeding;
        chanceForPoison = poison;
        chanceForFire = fire;
        chanceForFreezing = freezing;
    }

    public void effected(Creature creature, ArrayList<String> popUp) {
        Random random = new Random();

        if (random.nextInt(100) < chanceForBleeding) {
            creature.getStatistics().getEffect(EffectEnum.BLEEDING).apply();
            popUp.add("You have shed yours enemy blood");
        }
        if (random.nextInt(100) < chanceForPoison) {
            creature.getStatistics().getEffect(EffectEnum.POISON).apply();
            popUp.add("You poisoned the enemy's life!");
        }
        if (random.nextInt(100) < chanceForFire) {
            creature.getStatistics().getEffect(EffectEnum.IN_FIRE).apply();
            popUp.add("You put your enemy on fire!");
        }
        if (random.nextInt(100) < chanceForFreezing) {
            creature.getStatistics().getEffect(EffectEnum.FREEZING).apply();
            popUp.add("You frozen enemy hearth");
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getChanceForBleeding() {
        return chanceForBleeding;
    }

    public int getChanceForFire() {
        return chanceForFire;
    }

    public int getChanceForFreezing() {
        return chanceForFreezing;
    }

    public int getChanceForPoison() {
        return chanceForPoison;
    }

    public void upgrade(int damage, int bleeding, int poison, int fire, int freezing)
    {
        this.damage=damage;
        chanceForBleeding=bleeding;
        chanceForPoison=poison;
        chanceForFire=fire;
        chanceForFreezing=freezing;
    }
}
