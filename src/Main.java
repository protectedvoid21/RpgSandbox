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

public class Main {
    public static void main(String[] args) {
        new EntityManager("Warhammer");
        CustomAudioManager audioManager = new WarHammerAudioManager();
        audioManager.setAudioData(new AudioData(WarhammerEnumAudio.MAIN_AUDIO, "src/controllers/audio/music.wav", true));
        audioManager.setAudio(WarhammerEnumAudio.MAIN_AUDIO);
        Seeder seeder = new SeedManager();
        seeder.seed();
        //EntityManager.getInstance().saveAllEntities();
        SwingUtilities.invokeLater(() -> {
            ControllerManager controllerManager = new ControllerManager(new WarHammerFactory(), audioManager);
        });
    }
}