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
        
        EntityManager.getInstance().addCreature(playerCharacter1);
    }
}
