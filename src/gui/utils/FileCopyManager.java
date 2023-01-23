package gui.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FileCopyManager {
    private static String copyPath = "copyimages/";
    private static String  lastGeneratedNumber = null;

    public static void copyFile(String from) {
        try {
            Path src = Paths.get(from);
            Path dest = Paths.get(StringAdapter.getRelativePathBegin() + copyPath+generateRandomImgName());
            Files.copy(src.toFile().toPath(), dest.toFile().toPath());
        } catch (IOException ex) {
            System.out.println("Cannot copy this file!");
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
        } catch (IOException ex) {
        }
        return true;
    }

    public static String getPathToImage(String img){
        return StringAdapter.getRelativePathBegin()+copyPath+img;
    }

//    private static int calculateCopiedFilesNumber() {
//        int value = 0;
//        try {
//            var directoryStream = Files.newDirectoryStream(Paths.get(StringAdapter.getRelativePathBegin() + copyPath));
//            for (Path path : directoryStream) {
//                value++;
//            }
//        } catch (IOException ex) {
//        }
//        return value;
//    }

    public static String getLastFileName(){
        return lastGeneratedNumber;
    }

}
