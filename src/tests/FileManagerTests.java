package tests;

import game.creature.Experience;
import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.filehandle.FileManager;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FileManagerTests {
    private final FileManager fileManager = new FileManager("TestHammer");
    private List<PlayerCharacter> readPlayersList;
    
    @BeforeEach
    void seedData() {
        var playerCharacter1 = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        playerCharacter1.setName("Michal Krzysztofalik");

        fileManager.writeToFile(List.of(playerCharacter1), PlayerCharacter.class);
        readPlayersList = fileManager.readFromFile(PlayerCharacter.class);
    }
    
    @Test
    void addedPlayerCharactersShouldBeVisible() {
        Assertions.assertEquals("Michal Krzysztofalik", readPlayersList.get(0).getName());
        Assertions.assertNotNull(readPlayersList.get(0).getInventory());
        Assertions.assertNotNull(readPlayersList.get(0).getStruggleStatistics());
        Assertions.assertNotNull(readPlayersList.get(0).getStatistics());
    }

    @Test
    void statisticsAddedWithCreatureShouldHaveAttributes() {
        Assertions.assertNotNull(readPlayersList.get(0).getStatistics());
        
        var statistics = readPlayersList.get(0).getStatistics();
        
        for(var stat : AttributeEnum.values()) {
            Assertions.assertNotNull(statistics.getAttribute(stat));
        }
    }
}
