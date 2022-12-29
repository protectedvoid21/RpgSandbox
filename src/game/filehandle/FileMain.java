package game.filehandle;

import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.generals.LimitedAttribute;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.StatisticsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileMain {
    private static FileManager fileManager;
    
    public static void main(String[] args) {
        System.out.println("File tester");
        
        fileManager = new FileManager("Warhammer");
        
        //write();
        read();
    }
    
    static PlayerCharacter createSeedPlayer(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer());
        playerCharacter.setName(name);
        
        return playerCharacter;
    }
    
    static void write() {
        fileManager.writeToFile(createSeedPlayer("Kaspar Hauser"));
    }
    
    static void read() {
        var playersList = fileManager.readFromFile(PlayerCharacter.class);

        System.out.println(playersList.getStatistics());
    }
}
