package game.filehandle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import game.creature.Monster;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.equipment.Item;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {
    private final Map<Class, String> directoryMap = new HashMap<>();
    private final String gameName;
    
    public FileManager(String gameName) {
        this.gameName = gameName;
        
        directoryMap.put(Monster.class, "monsters.txt");
        directoryMap.put(NPC.class, "npcs.txt");
        directoryMap.put(PlayerCharacter.class, "players.txt");
        directoryMap.put(Item.class, "items.txt");
        //directoryMap.put(Spell.class, "spells.txt");
        
        try {
            ensurePathExists();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void ensurePathExists() throws IOException {
        Path dataPath = Paths.get("data");
        Path gamePath = Paths.get("data", gameName);
        if(!Files.exists(dataPath)) {
            Files.createDirectory(dataPath);
            
        }
        if(!Files.exists(gamePath)) {
            Files.createDirectory(gamePath);
        }
        
        List<String> fileNames = directoryMap.values().stream().toList();
        
        for(var fileName : fileNames) {
            if(!Files.exists(Path.of(gamePath + fileName))) {
                File file = new File((gamePath + "/" + fileName));
                file.createNewFile();
            }
        }
    }
    
    public void writeToFile(Object object) throws IOException {
        if(!directoryMap.containsKey(object.getClass())) {
            System.out.println("The object doesn't exist in directoryMap as a key");
            return;
        }
        
        String savePath = "data/" + directoryMap.get(object.getClass());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(savePath));

        bufferedWriter.write(gson.toJson(object));
        bufferedWriter.close();
    }

    /*public <T> List<T> readFromFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Gson gson = new Gson();
        Type typeOfT = new TypeToken<T>(){}.getType();

        return gson.fromJson(bufferedReader, typeOfT);
    }*/
}
