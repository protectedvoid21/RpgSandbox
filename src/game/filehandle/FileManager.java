package game.filehandle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controllers.audio.ICustomEnumAudio;
import game.board.Scenario;
import game.creature.Character;
import game.creature.Creature;
import game.creature.Monster;
import game.creature.NPC;
import game.creature.PlayerCharacter;
import game.equipment.*;
import game.generals.AttributeValue;
import game.interfaces.*;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManager {
    private final Map<Class, String> directoryMap = new HashMap<>();
    private final String gameName;
    private final Gson gson;

    public FileManager(String gameName) {
        this.gameName = gameName;

        directoryMap.put(Monster.class, "monsters.txt");
        directoryMap.put(NPC.class, "npcs.txt");
        directoryMap.put(PlayerCharacter.class, "players.txt");
        directoryMap.put(Weapon.class, "weapons.txt");
        directoryMap.put(Armor.class, "armors.txt");
        directoryMap.put(Mount.class, "mounts.txt");
        directoryMap.put(Scenario.class, "scenarios.txt");

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setExclusionStrategies(new CustomExcludeStrategy())
                .registerTypeAdapter(IStatistics.class, new StatisticsDeserializer())
                .registerTypeAdapter(Creature.class, new CustomAdapter<Creature>())
                .registerTypeAdapter(IStruggleStatistics.class, new StruggleDeserializer())
                .registerTypeAdapter(IStruggleAtributeEnum.class, new CustomAdapter<IStruggleAtributeEnum>())
                .registerTypeAdapter(ICustomEnumAudio.class, new AudioDeserializer())
                .registerTypeAdapter(IAttributeEnum.class, new CustomAdapter<IAttributeEnum>())
                .registerTypeAdapter(AttributeValue.class, new CustomAdapter<AttributeValue>())
                .registerTypeAdapter(DisposableItem.class, new CustomAdapter<DisposableItem>())
                .create();
        try {
            ensurePathExists();
        } catch (IOException e) {
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

    public <T> void writeToFile(List<T> object, Class<T> objectType) {
        if (!directoryMap.containsKey(objectType)) {
            System.out.println("The " + objectType + " doesn't exist in directoryMap as a key");
            return;
        }

        String savePath = "data/" + gameName + "/" + directoryMap.get(objectType);

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(savePath));
            gson.toJson(object, bufferedWriter);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> readFromFile(Class<T> objectType) {
        if (!directoryMap.containsKey(objectType)) {
            System.out.println("The " + objectType.toString() + " doesn't exist in directoryMap as a key");
            return new ArrayList<>();
        }

        FileReader fileReader;
        try {
            fileReader = new FileReader("data/" + gameName + "/" + directoryMap.get(objectType));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Type typeOfList = TypeToken.getParameterized(List.class, objectType).getType();

        List<T> deserializedList = gson.fromJson(bufferedReader, typeOfList);
        return deserializedList == null ? new ArrayList<>() : deserializedList;
    }
}
