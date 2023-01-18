package gui.utils;

public class StringAdapter {
    private static String relativePathBegin = "src/gui/";
    public static String getRelativePath(String path){
        return relativePathBegin+path;
    }
    public static String getRelativePathBegin(){
        return relativePathBegin;
    }
}
