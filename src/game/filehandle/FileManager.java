package game.filehandle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;
import game.Spells;
import game.creature.Monster;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.equipment.Item;
import game.generals.AttributeValue;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.IAttributeEnum;
import game.interfaces.IStatistics;
import game.interfaces.Statistics;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileManager {
    private final Map<Class, String> directoryMap = new HashMap<>();
    private final String gameName;
    private final Gson gson;

    public FileManager(String gameName) {
        this.gameName = gameName;
        
        directoryMap.put(Monster.class, "monsters.txt");
        directoryMap.put(NPC.class, "npcs.txt");
        directoryMap.put(PlayerCharacter.class, "players.txt");
        directoryMap.put(Item.class, "items.txt");
        //directoryMap.put(Spell.class, "spells.txt");
        gson = new GsonBuilder()
                .registerTypeAdapter(Statistics.class, new CustomAdapter<Statistics>())
                .registerTypeAdapter(Map.class, new CustomAdapter<Map<AttributeEnum, AttributeValue>>())
                .registerTypeAdapter(AttributeEnum.class, new CustomAdapter<AttributeEnum>())
                .registerTypeAdapter(AttributeValue.class, new CustomAdapter<AttributeValue>())
                .setPrettyPrinting()
                .addSerializationExclusionStrategy(new ExclusionStrategyBuilder().create())
                //.addDeserializationExclusionStrategy(new ExclusionStrategyBuilder().create())
                //.addDeserializationExclusionStrategy(new )
                .create();

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
        if (!Files.exists(dataPath)) {
            Files.createDirectory(dataPath);

        }
        if (!Files.exists(gamePath)) {
            Files.createDirectory(gamePath);
        }

        List<String> fileNames = directoryMap.values().stream().toList();

        for (var fileName : fileNames) {
            if (!Files.exists(Path.of(gamePath + fileName))) {
                File file = new File((gamePath + "/" + fileName));
                file.createNewFile();
            }
        }
    }

    public void writeToFile(Object object) {
        if (!directoryMap.containsKey(object.getClass())) {
            System.out.println("The " + object.getClass() + " doesn't exist in directoryMap as a key");
            return;
        }

        String savePath = "data/" + gameName + "/" + directoryMap.get(object.getClass());

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(savePath));
            bufferedWriter.write(gson.toJson(object));
            bufferedWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateObject(Object object) {

    }

    public PlayerCharacter readFromFile(Class objectType) {
        if (!directoryMap.containsKey(objectType)) {
            System.out.println("The " + objectType.toString() + " doesn't exist in directoryMap as a key");
            return null;
        }

        FileReader fileReader;
        try {
            fileReader = new FileReader("data/" + gameName + "/" + directoryMap.get(objectType));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Type type = new TypeToken<PlayerCharacter>(){}.getType();

        return gson.fromJson(bufferedReader, type);
    }
}
