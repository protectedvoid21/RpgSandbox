package gui.utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;

public class FileManager {
    private static String copyPath = "copyimages/";
    private static String  lastGeneratedNumber = null;

    public static void copyFile(String from) {
        try {
            Path src = Paths.get(from);
            Path dest = Paths.get(StringAdapter.getRelativePathBegin() +copyPath+generateRandomImgName());
            System.out.println(src.toFile().toPath());
            System.out.println(dest.toFile().toPath());
            Files.copy(src.toFile().toPath(), dest.toFile().toPath());
        } catch (IOException ex) {
            System.out.println("Cannot copy this file!");
        }
    }

    public static void deleteFile(String src){
        Path path = FileSystems.getDefault().getPath(src);
        try {
            Files.delete(path);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    private static String generateRandomImgName(){
        do{
            var num = ThreadLocalRandom.current().nextInt(1, 100000000);
            lastGeneratedNumber = "imgCode"+num+".jpg";
        }while (!isNameValid(lastGeneratedNumber));
        return lastGeneratedNumber;
    }
    private static boolean isNameValid(String name){
        try {
            var directoryStream = Files.newDirectoryStream(Paths.get(StringAdapter.getRelativePathBegin() + copyPath));
            for (Path path : directoryStream) {
                if(name.equals(path.getFileName())){
                    return false;
                }
            }
        } catch (IOException ignored) {
        }
        return true;
    }

    public static String getPathToImage(String img){
        return StringAdapter.getRelativePathBegin()+copyPath+img;
    }

    public static String getLastFileName(){
        return lastGeneratedNumber;
    }

}
