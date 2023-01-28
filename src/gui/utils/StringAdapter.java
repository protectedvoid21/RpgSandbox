package gui.utils;

public class StringAdapter {
    private static String relativePathBegin = "src/gui/guiImages/";
    private static String fontRelativePath = "src/gui/fonts/";

    public static String getRelativePath(String path) {
        return relativePathBegin + path;
    }

    public static String getMonsterRelativePath(String path) {
        return relativePathBegin +"Character/Monsters/"+ path;
    }
    public static String getNPCRelativePath(String path) {
        return relativePathBegin +"Character/NPC/"+ path;
    }
    public static String getPlayerRelativePath(String path) {
        return relativePathBegin +"Character/PlayerCharacter/"+ path;
    }
    public static String getActionsRelativePath(String path) {
        return relativePathBegin +"Game/Actions/"+ path;
    }
    public static String getDiceRelativePath(String path) {
        return relativePathBegin +"Game/Dice/"+ path;
    }
    public static String getEffectsRelativePath(String path) {
        return relativePathBegin +"Game/Effects/"+ path;
    }
    public static String getViewsRelativePath(String path) {
        return relativePathBegin +"Game/Vievs/"+ path;
    }
    public static String getWeaponsRelativePath(String path) {
        return relativePathBegin +"Items/Weapons/"+ path;
    }
    public static String getMountsRelativePath(String path) {
        return relativePathBegin +"Items/Mounts/"+ path;
    }
    public static String getArmorsRelativePath(String path) {
        return relativePathBegin + "Items/Armors/"+path;
    }
    public static String getItemsRelativePath(String path) {
        return relativePathBegin +"Items/DisposableItems/"+ path;
    }
    public static String getFontRelativePath(String path) {
        return fontRelativePath + path;
    }

    public static String getRelativePathBegin() {
        return "src/gui/";
    }
}
