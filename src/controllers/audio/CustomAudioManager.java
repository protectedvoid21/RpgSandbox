package controllers.audio;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class CustomAudioManager {
    protected HashMap<ICustomEnumAudio, Audio> audioHashMap = new HashMap<>();
    protected Audio currentRunAudio;

    public void setAudio(ICustomEnumAudio audio) {
        if (currentRunAudio != null) {
            currentRunAudio.stop();
        }
        currentRunAudio = audioHashMap.get(audio);
        new Thread(() -> {
            currentRunAudio.runMainClip();
        }).start();
    }

    public void setSoundOff() {
        for (var audio : audioHashMap.values()) {
            audio.setBlocked(true);
        }
    }

    public void setSoundOn() {
        for (var audio : audioHashMap.values()) {
            audio.setBlocked(false);
        }
    }


    public void setAudioData(AudioData data) {
        var customAudio = new Audio();
        customAudio.setMainClip(data.audio, data.loop);
        audioHashMap.put(data.enumName, customAudio);
    }


}