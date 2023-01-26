import controllers.ControllerManager;
import controllers.audio.AudioData;
import controllers.audio.CustomAudioManager;
import controllers.audio.WarHammerAudioManager;
import controllers.audio.WarhammerEnumAudio;
import game.filehandle.EntityManager;
import game.utils.seeders.SeedManager;
import game.utils.seeders.Seeder;
import gui.factories.WarHammerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        new EntityManager("Warhammer");
        WarHammerAudioManager audioManager = new WarHammerAudioManager();
        audioManager.initialize();
        Seeder seeder = new SeedManager();
//        seeder.seed();
//        EntityManager.getInstance().saveAllEntities();
        SwingUtilities.invokeLater(() -> {
            ControllerManager controllerManager = new ControllerManager(new WarHammerFactory(), audioManager);
        });
    }
}