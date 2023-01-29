import controllers.ControllerManager;
import controllers.audio.WarHammerAudioManager;
import game.filehandle.EntityManager;
import game.utils.seeders.SeedManager;
import game.utils.seeders.Seeder;
import gui.bundle.CustomBundle;
import gui.factories.WarHammerFactory;
import gui.utils.Converter;

import javax.swing.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        new EntityManager("Warhammer");
        new CustomBundle(new Locale("de", "DE"));
        WarHammerAudioManager audioManager = new WarHammerAudioManager();
        audioManager.initialize();
        Seeder seeder = new SeedManager();
//        seeder.seed();
//        EntityManager.getInstance().saveAllEntities();
        SwingUtilities.invokeLater(() -> {
            var manager = new ControllerManager(new WarHammerFactory(), audioManager, new Converter());
            manager.setFrameData("Warhammer", "war.png");
        });
    }
}