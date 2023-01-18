package gui.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyManager {
    private static String copyPath = "copyimages/";

    public static void copyFile(String from) {
        try {
            Path src = Paths.get(from);
            Path dest = Paths.get(StringAdapter.getRelativePathBegin() + copyPath+"copiedFileNum"+calculateCopiedFilesNumber()+".jpg");
            Files.copy(src.toFile().toPath(), dest.toFile().toPath());
        } catch (IOException ex) {
            System.out.println("Cannot copy this file!");
        }
    }

    private static int calculateCopiedFilesNumber() {
        int value = 0;
        try {
            var directoryStream = Files.newDirectoryStream(Paths.get(StringAdapter.getRelativePathBegin() + copyPath));
            for (Path path : directoryStream) {
                value++;
            }
        } catch (IOException ex) {
        }
        return value;
    }

    public static String getLastFileName(){
        return "copiedFileNum"+(calculateCopiedFilesNumber()-1)+".jpg";
    }

}
