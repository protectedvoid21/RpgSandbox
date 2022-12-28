package game.filehandle;

import game.creature.PlayerCharacter;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.StatisticsBuilder;

public class FileMain {
    public static void main(String[] args) {
        System.out.println("File tester");
        
        FileManager fileManager = new FileManager("Warhammer");
        
        fileManager.writeToFile(createSeedPlayer());
    
        
    }
    
    static PlayerCharacter createSeedPlayer() {
        PlayerCharacter playerCharacter = new PlayerCharacter(new StatisticsWarhammer());
        
        return playerCharacter;
    }
}
