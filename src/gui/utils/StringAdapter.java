package gui.utils;

import controllers.audio.WarhammerEnumAudio;

import java.util.HashMap;
import java.util.Map;

public class StringAdapter {

    public enum Directories {MONSTERS, NPC, PLAYERS, ACTIONS, EFFECTS, VIEWS, MOUNTS, ARMORS, ITEMS, WEAPONS}

    ;
    private static Map<Directories, String> directoriesStringHashMap = Map.of(Directories.MONSTERS, "Character" +
                    "/Monsters/",
            Directories.NPC, "Character/NPC/", Directories.PLAYERS, "Character/PlayerCharacter/", Directories.ACTIONS
            , "Game/Actions/", Directories.MOUNTS, "Items/Mounts/", Directories.EFFECTS, "Game/Effects/",
            Directories.VIEWS, "Game/Vievs/", Directories.WEAPONS, "Items/Weapons/", Directories.ARMORS, "Items" +
                    "/Armors/", Directories.ITEMS, "Items/DisposableItems/");
    private static String relativePathBegin = "src/gui/guiImages/";
    private static String fontRelativePath = "src/gui/fonts/";

    public static String getDirectoryPath(Directories dir){
        return relativePathBegin + directoriesStringHashMap.get(dir);
    }

    public static String getRelativePath(String path) {
        return relativePathBegin + path;
    }

    public static String getMonsterRelativePath(String path) {
        return getFromPattern(Directories.MONSTERS, path);
    }

    public static String getNPCRelativePath(String path) {
        return getFromPattern(Directories.NPC, path);
    }

    public static String getPlayerRelativePath(String path) {
        return getFromPattern(Directories.PLAYERS, path);
    }

    public static String getActionsRelativePath(String path) {
        return getFromPattern(Directories.ACTIONS, path);
    }

    public static String getEffectsRelativePath(String path) {
        return getFromPattern(Directories.EFFECTS, path);
    }

    public static String getViewsRelativePath(String path) {
        return getFromPattern(Directories.VIEWS, path);
    }

    public static String getWeaponsRelativePath(String path) {
        return getFromPattern(Directories.WEAPONS, path);
    }

    public static String getMountsRelativePath(String path) {
        return getFromPattern(Directories.MOUNTS, path);
    }

    public static String getArmorsRelativePath(String path) {
        return getFromPattern(Directories.ARMORS, path);
    }

    public static String getItemsRelativePath(String path) {
        return getFromPattern(Directories.ITEMS, path);
    }

    public static String getFontRelativePath(String path) {
        return fontRelativePath + path;
    }

    private static String getFromPattern(Directories dir, String path) {
        return relativePathBegin + directoriesStringHashMap.get(dir) + path;
    }

    public static String getRelativePathBegin() {
        return "src/gui/";
    }
}
