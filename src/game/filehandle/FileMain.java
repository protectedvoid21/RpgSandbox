package game.filehandle;

import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.generals.AttributeValue;
import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.WarhammerStatisticsBuilder;
import game.interfaces.IAttributeEnum;
import game.interfaces.StatisticsBuilder;

import java.util.*;

public class FileMain {
    private static FileManager fileManager;
    
    public static void main(String[] args) {
        System.out.println("File tester");
        
        fileManager = new FileManager("Warhammer");
        
        write();
        read();
    }
    
    static PlayerCharacter createSeedPlayer(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), new Inventory());
        playerCharacter.setName(name);
        
        return playerCharacter;
    }
    
    static List<PlayerCharacter> createManyPlayers() {
        ArrayList<PlayerCharacter> players = new ArrayList<>();
        players.add(createSeedPlayer("Kaspar Hauser"));
        players.add(createSeedPlayer("Adam Tadam"));
        players.add(createSeedPlayer("Cyka Blyat"));
        
        return players;
    }
    
    static void write() {
        fileManager.writeToFile(createManyPlayers(), PlayerCharacter.class);
    }
    
    static void read() {
        var playersList = fileManager.readFromFile(PlayerCharacter.class);

        System.out.println(playersList);
    }
}
