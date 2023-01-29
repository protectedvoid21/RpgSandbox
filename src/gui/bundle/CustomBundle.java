package gui.bundle;

import game.filehandle.EntityManager;
import game.filehandle.FileManager;
import gui.data.TextData;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class CustomBundle implements TextData {
    private static ResourceBundle instance;

    public CustomBundle(Locale locale) {
        if (instance == null) {
            File file = new File(resourcePath);
            URL[] urls;
            try {
                urls = new URL[]{file.toURI().toURL()};
                ClassLoader loader = new URLClassLoader(urls);
                instance = ResourceBundle.getBundle("RpgBundle", locale, loader);
            } catch (MalformedURLException ignored) {
                System.out.println("Cannot find file for bundle!");
            }
        }
    }

    public static ResourceBundle getInstance() {
        return instance;
    }

    public static void changeLanguage(Locale locale){
        Locale.setDefault(locale);
    }

    public static String getString(String key){
        return instance.getString(key);
    }
}
