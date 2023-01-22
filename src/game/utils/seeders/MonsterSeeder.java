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
        monster1.setName("Adam");
        Monster monster2 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster2.setName("Kaspar");
        Monster monster3 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster3.setName("Krzysztof");
        
        EntityManager.getInstance().addCreature(monster1);
        EntityManager.getInstance().addCreature(monster2);
        EntityManager.getInstance().addCreature(monster3);
    }
}
