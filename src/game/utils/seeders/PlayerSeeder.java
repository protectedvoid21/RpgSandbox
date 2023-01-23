package game.utils.seeders;

import game.creature.Experience;
import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.filehandle.EntityManager;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

public class PlayerSeeder implements Seeder {
    @Override
    public void seed() {
        PlayerCharacter playerCharacter1 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter1.setName("Michalik");
        PlayerCharacter playerCharacter2 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter2.setName("Adamow");
        PlayerCharacter playerCharacter3 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter3.setName("Iwaszkiewicz");
        PlayerCharacter playerCharacter4 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter4.setName("Hawking");
        PlayerCharacter playerCharacter5 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter5.setName("Lipton");
        
        EntityManager.getInstance().addCreature(playerCharacter1);
        EntityManager.getInstance().addCreature(playerCharacter2);
        EntityManager.getInstance().addCreature(playerCharacter3);
        EntityManager.getInstance().addCreature(playerCharacter4);
        EntityManager.getInstance().addCreature(playerCharacter5);
    }
}
