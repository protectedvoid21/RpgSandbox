package game.filehandle;

import game.creature.Experience;
import game.creature.PlayerCharacter;
import game.equipment.Inventory;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

import java.util.*;

public class FileTester {
    private static FileManager fileManager;
    
    public static void main(String[] args) {
        System.out.println("Running file tester");
        
        fileManager = new FileManager("Warhammer");
        
        write();
        read();
    }
    
    static PlayerCharacter createSeedPlayer(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
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
        System.out.println("Writing to file...");
        fileManager.writeToFile(createManyPlayers(), PlayerCharacter.class);
    }
    
    static void read() {
        System.out.println("Reading from file...");
        List<PlayerCharacter> playersList = fileManager.readFromFile(PlayerCharacter.class);
        
        System.out.println(playersList);
    }
}
