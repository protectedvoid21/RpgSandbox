package game.filehandle;

import game.creature.Monster;
import game.creature.PlayerCharacter;
import game.generals.LimitedAttribute;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.StatisticsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileMain {
    public static void main(String[] args) {
        System.out.println("File tester");
        
        FileManager fileManager = new FileManager("Warhammer");

        //fileManager.writeToFile(createSeedPlayer("Kacper"));
        
        var playersList = fileManager.readFromFile(PlayerCharacter.class);
        
        System.out.println(playersList);
    }
    
    static PlayerCharacter createSeedPlayer(String name) {
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer());
        playerCharacter.setName(name);
        
        return playerCharacter;
    }
}
