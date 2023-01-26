package controllers.audio;

import javax.swing.*;

public class WarHammerAudioManager extends CustomAudioManager {

    public void initialize() {
        setAudioData(new AudioData(WarhammerEnumAudio.MAIN_AUDIO, "src/controllers/audio/music.wav", true));
//        setSoundOff();
//        audioHashMap.get(WarhammerEnumAudio.MAIN_AUDIO).stop();
         setAudio(WarhammerEnumAudio.MAIN_AUDIO);
//        setAudio(WarhammerEnumAudio.MAIN_AUDIO);
//        audioHashMap.get(WarhammerEnumAudio.MAIN_AUDIO).stop();
//        var t = new Timer(1, e -> setSoundOff());
//        t.start();
//        t.setRepeats(false);
    }

    @Override
    public void setAudio(ICustomEnumAudio audio) {

        super.setAudio(audio);
        if (audio != WarhammerEnumAudio.MAIN_AUDIO) {
            currentRunAudio.setActivityOnStop(() -> {
                setAudio(WarhammerEnumAudio.MAIN_AUDIO);

            });
        }
    }
}
