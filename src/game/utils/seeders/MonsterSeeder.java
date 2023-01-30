package game.utils.seeders;

import game.creature.Experience;
import game.creature.Monster;
import game.filehandle.EntityManager;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import gui.data.WarhammerData;

public class MonsterSeeder implements Seeder, WarhammerData {
    @Override
    public void seed() {
        Monster monster1 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster1.setName("Adam");
        monster1.setObjectPathPicture(dragonPath);
        Monster monster2 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster2.setName("Kaspar");
        monster2.setObjectPathPicture(knightPath);
        Monster monster3 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster3.setName("Krzysztof");
        monster3.setObjectPathPicture(monsterek);
        Monster monster4 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster4.setName("Andrzej");
        monster4.setObjectPathPicture(snowmanPath);
        Monster monster5 = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        monster5.setName("Zdzis");
        monster5.setObjectPathPicture(witchPath);
        
        EntityManager.getInstance().addCreature(monster1);
        EntityManager.getInstance().addCreature(monster2);
        EntityManager.getInstance().addCreature(monster3);
        EntityManager.getInstance().addCreature(monster4);
        EntityManager.getInstance().addCreature(monster5);
    }
}
