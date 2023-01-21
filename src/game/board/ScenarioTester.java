package game.board;

import game.creature.Experience;
import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.filehandle.EntityManager;
import game.filehandle.FileManager;
import game.generals.Vector2;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

import java.util.ArrayList;
import java.util.List;

public class ScenarioTester {
    public static void main(String[] args) {
        List<ScenarioData> scenarioData = new ArrayList<>();

        scenarioData.add(new ScenarioData());
        scenarioData.add(new ScenarioData());
        scenarioData.add(new ScenarioData());
        scenarioData.add(new ScenarioData());

        scenarioData.get(0).position = new Vector2(1, 1);
        scenarioData.get(0).creature = new Monster(new StatisticsWarhammer(), new Experience(0), new StruggleStatisticsWarhammer());

        scenarioData.get(1).position = new Vector2(2, 2);
        scenarioData.get(1).creature = new Monster(new StatisticsWarhammer(), new Experience(1), new StruggleStatisticsWarhammer());

        scenarioData.get(2).position = new Vector2(5, 5);
        scenarioData.get(2).creature = new Monster(new StatisticsWarhammer(), new Experience(2), new StruggleStatisticsWarhammer());

        scenarioData.get(3).position = new Vector2(0, 0);
        scenarioData.get(3).creature = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(10), new StruggleStatisticsWarhammer());
        
        Scenario scenario = new Scenario(10, 10, scenarioData);
        EntityManager.getInstance().addScenario(scenario);
    }
}
