package game.equipment;

import game.creature.Creature;
import game.interfaceWarhammer.EffectEnum;

import java.util.Random;

public class Weapon extends ManyUsageItem {
    private int damage;
    private int range;
    private int chanceForBleeding;
    private int chanceForShocked;
    private int chanceForPoison;
    private int chanceForFire;
    private int chanceForFreezing;

    public Weapon(String name, int damage, int range) {
        super(name);
        Random random = new Random();

        this.range=range;
        this.damage = damage;
        chanceForBleeding = random.nextInt(101);
        chanceForShocked = random.nextInt(101);
        chanceForPoison = random.nextInt(101);
        chanceForFire = random.nextInt(101);
        chanceForFreezing = random.nextInt(101);
    }

    public Weapon(String name, int damage, int range, int bleeding, int shocked, int poison, int fire, int freezing) {
        super(name);
        this.damage = damage;
        this.range=range;
        chanceForBleeding = bleeding;
        chanceForShocked = shocked;
        chanceForPoison = poison;
        chanceForFire = fire;
        chanceForFreezing = freezing;
    }

    public void effected(Creature creature)
    {
        Random random = new Random();

        if(random.nextInt(100)<chanceForBleeding)
        {
            creature.getStatistics().getEffect(EffectEnum.BLEEDING).apply();
        }
        if(random.nextInt(100)<chanceForShocked)
        {
            creature.getStatistics().getEffect(EffectEnum.SHOCKED).apply();
        }
        if(random.nextInt(100)<chanceForPoison)
        {
            creature.getStatistics().getEffect(EffectEnum.POISON).apply();
        }
        if(random.nextInt(100)<chanceForFire)
        {
            creature.getStatistics().getEffect(EffectEnum.IN_FIRE).apply();
        }
        if(random.nextInt(100)<chanceForFreezing)
        {
            creature.getStatistics().getEffect(EffectEnum.FREEZING).apply();
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
}
