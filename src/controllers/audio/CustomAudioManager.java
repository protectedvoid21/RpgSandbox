package controllers.audio;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class CustomAudioManager {

    private boolean startStatus = false;
    protected HashMap<ICustomEnumAudio, Audio> audioHashMap = new HashMap<>();
    protected Audio currentRunAudio;
    public void setAudio(ICustomEnumAudio audio) {
        if(currentRunAudio!=null){
            currentRunAudio.stop();
        }
        currentRunAudio = audioHashMap.get(audio);
        new Thread(() -> currentRunAudio.runMainClip()).start();
    }


//    private float sound;
    public void setSoundOff(){
        for (var audio : audioHashMap.values() ){
            audio.setBlocked(true);
        }
    }
    public void setSoundOn(){
        for (var audio : audioHashMap.values() ){
            audio.setBlocked(false);
        }
    }

    public void setAudioData(ICustomEnumAudio enumName, String audio, boolean loop){

        var customAudio = new Audio();
        customAudio.setMainClip(audio, loop);
        audioHashMap.put(enumName, customAudio);
    }

    public void setAudioData(AudioData data){
        var customAudio = new Audio();
        customAudio.setMainClip(data.audio, data.loop);
        audioHashMap.put(data.enumName, customAudio);
    }



    public static void main(String[] args) {
        CustomAudioManager audioManager = new WarHammerAudioManager();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ramka = new JFrame();
                ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ramka.setSize(800, 800);
                var but = new JButton();
                var but2 = new JButton();
                var but3 = new JButton();
                but2.addActionListener(e -> audioManager.setAudio(WarhammerEnumAudio.MAIN_AUDIO));

                ramka.setLayout(new BorderLayout());
                but.addActionListener(e -> audioManager.setAudio(WarhammerEnumAudio.BOMB_AUDIO));
                ramka.add(but, BorderLayout.CENTER);
                ramka.add(but2, BorderLayout.EAST);
                ramka.add(but3, BorderLayout.NORTH);
                ramka.setVisible(true);
            }
        });
        audioManager.setAudioData(WarhammerEnumAudio.MAIN_AUDIO, "src/controllers/audio/music3.wav", true);
        audioManager.setAudioData(WarhammerEnumAudio.BOMB_AUDIO, "src/controllers/audio/audio.wav", false);
    }

}
