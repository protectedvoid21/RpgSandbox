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

    private static int currentLanguageIndex = 0;
    private static CustomBundle classInstance;
    private ResourceBundle instance;
    private ResourceBundle specificInstance;

    public CustomBundle(Locale locale) {
        if (classInstance == null) {
            classInstance = generateClassInstance(locale);
            setInstance(locale);
        }
    }

    public static void setLanguageIndex(int value){
        currentLanguageIndex = value;
    }
    public static int getCurrentLanguageIndex(){
        return currentLanguageIndex;
    }

    protected abstract CustomBundle generateClassInstance(Locale locale);

    private void setInstance(Locale locale){
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

    protected abstract ResourceBundle generateSpecificInstance(Locale locale, ClassLoader loader);

    public static void changeLanguage(Locale locale){
        classInstance.setInstance(locale);
    }

    public static String getDefaultString(String key){
        return classInstance.instance.getString(key);
    }
    public static String getSpecificString(String key){
        return classInstance.specificInstance.getString(key);
    }
}
