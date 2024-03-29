package game.utils.seeders;

import game.board.Scenario;
import game.board.ScenarioData;
import game.creature.Experience;
import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.equipment.Armor;
import game.equipment.Inventory;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.filehandle.EntityManager;
import game.generals.Vector2;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import gui.data.WarhammerData;

import java.util.ArrayList;
import java.util.List;

public class ScenarioSeeder implements Seeder, WarhammerData {
    @Override
    public void seed() {
        new EntityManager("Warhammer");

        List<ScenarioData> scenarioData = new ArrayList<>();

        scenarioData.add(new ScenarioData());
        scenarioData.add(new ScenarioData());
        scenarioData.add(new ScenarioData());
        scenarioData.add(new ScenarioData());

        scenarioData.get(0).position = new Vector2(1, 1);
        scenarioData.get(0).creature = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());
        scenarioData.get(0).creature.setObjectPathPicture(witchPath);
        scenarioData.get(1).position = new Vector2(2, 2);
        scenarioData.get(1).creature = new Monster(new StatisticsWarhammer(), new Experience(1), new StruggleStatisticsWarhammer());
        scenarioData.get(1).creature.setObjectPathPicture(trolleyPath);
        scenarioData.get(2).position = new Vector2(5, 5);
        scenarioData.get(2).creature = new Monster(new StatisticsWarhammer(), new Experience(2), new StruggleStatisticsWarhammer());
        scenarioData.get(2).creature.setObjectPathPicture(statsPath);
        scenarioData.get(3).position = new Vector2(0, 0);

        Weapon weapon = new Weapon("weapon1", 10, 10,50,50,50,50);
        Mount mount = new Mount("horse1", 20);
        Mount mount1 = new Mount("horse2", 30);
        Mount mount2 = new Mount("horse3", 40);
        Armor armor = new Armor("armor1", 45);
        Inventory inventory = new Inventory();
        inventory.addItem(weapon);
        inventory.addItem(mount);
        inventory.addItem(mount1);
        inventory.addItem(mount2);
        inventory.addItem(armor);
        scenarioData.get(3).creature = new PlayerCharacter(new StatisticsWarhammer(), inventory, new Experience(10), new StruggleStatisticsWarhammer());
        scenarioData.get(3).creature.setObjectPathPicture(witchPath);
        for (int i = 0; i<4; i++){
            scenarioData.get(i).creature.setName("zdzichu" + i);
        }
        Scenario scenario = new Scenario(10, 10, scenarioData);
        EntityManager.getInstance().addScenario(scenario);
    }
}
