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

public abstract class CustomBundle implements TextData {
    private static ResourceBundle instance;
    private static ResourceBundle specificInstance;

    public CustomBundle(Locale locale) {
        if (instance == null) {
            File file = new File(resourcePath);
            URL[] urls;
            try {
                urls = new URL[]{file.toURI().toURL()};
                ClassLoader loader = new URLClassLoader(urls);
                instance = ResourceBundle.getBundle("RpgBundle", locale, loader);
                specificInstance = generateSpecificInstance(locale, loader);
            } catch (MalformedURLException ignored) {
                System.out.println("Cannot find file for bundle!");
            }
        }
    }

    protected abstract ResourceBundle generateSpecificInstance(Locale locale, ClassLoader loader);

//    public static void changeLanguage(Locale locale){
//        Locale.setDefault(locale);
//    }

    public static String getDefaultString(String key){
        return instance.getString(key);
    }
    public static String getSpecificString(String key){
        return specificInstance.getString(key);
    }
}
