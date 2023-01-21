package game.utils.seeders;

import game.creature.Experience;
import game.creature.Monster;
import game.filehandle.EntityManager;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

public class MonsterSeeder implements Seeder {
    @Override
    public void seed() {
        Monster monster1 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        
        EntityManager.getInstance().addCreature(monster1);
    }
}
