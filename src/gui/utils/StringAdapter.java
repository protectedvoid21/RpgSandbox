package gui.utils;

public class StringAdapter {
    private static String relativePathBegin = "src/gui/guiImages/";
    private static String fontRelativePath = "src/gui/fonts/";
    public static String getRelativePath(String path){
        return relativePathBegin+path;
    }

    public static String getFontRelativePath(String path){
        return fontRelativePath+path;
    }
    public static String getRelativePathBegin(){
        return "src/gui/";
    }
}
