package game.filehandle;

import game.creature.Experience;
import game.creature.Monster;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.equipment.Armor;
import game.equipment.Inventory;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

public class DummyCreator {
    
    public static PlayerCharacter getPlayerCharacter() {
        return new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
    }

    public static Monster getMonster() {
        return new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
    }
    
    public static NPC getNPC() {
        return new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
    }
    
    public static Weapon getWeapon() {
        return new Weapon("Unnamed", 10, 2);
    }

    public static Mount getMount() {
        return new Mount("Unnamed", 3);
    }

    public static Armor getArmor() {
        return new Armor("Unnamed", 5);
    }
}
