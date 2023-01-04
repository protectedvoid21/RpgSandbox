package game.equipment;

import game.interfaceWarhammer.EffectEnum;
import game.interfaces.IEffectEnum;
import game.interfaces.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public class Weapon extends ManyUsageItem {
    private int damage;
    private int range;
    private double chanceForBleeding;
    private double chanceForShocked;
    private double chanceForPoison;
    private double chanceForFire;
    private double chanceForFreezing;

    public Weapon(String name, int damage, int range) {
        super(name);
        Random random = new Random();

        this.range=range;
        this.damage = damage;
        chanceForBleeding = random.nextDouble();
        chanceForShocked = random.nextDouble();
        chanceForPoison = random.nextDouble();
        chanceForFire = random.nextDouble();
        chanceForFreezing = random.nextDouble();
    }

    public Weapon(String name, int damage, int range, double bleeding, double shocked, double poison, double fire, double freezing) {
        super(name);
        this.damage = damage;
        this.range=range;
        chanceForBleeding = bleeding;
        chanceForShocked = shocked;
        chanceForPoison = poison;
        chanceForFire = fire;
        chanceForFreezing = freezing;
    }

    public ArrayList<IEffectEnum> effected()
    {
        ArrayList<IEffectEnum> temp = new ArrayList<>();
        Random random = new Random();

        if(random.nextDouble()<chanceForBleeding)
        {
            temp.add(EffectEnum.BLEEDING);
        }
        if(random.nextDouble()<chanceForShocked)
        {
            temp.add(EffectEnum.SHOCKED);
        }
        if(random.nextDouble()<chanceForPoison)
        {
            temp.add(EffectEnum.POISON);
        }
        if(random.nextDouble()<chanceForFire)
        {
            temp.add(EffectEnum.IN_FIRE);
        }
        if(random.nextDouble()<chanceForFreezing)
        {
            temp.add(EffectEnum.FREEZING);
        }

        return temp;
    }

    public int getDamage() {
        return damage;
    }
}
