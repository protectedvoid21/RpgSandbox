package controllers.audio;

import javax.swing.*;

public class WarHammerAudioManager extends CustomAudioManager {

    public void initialize() {
        setAudioData(new AudioData(WarhammerEnumAudio.MAIN_AUDIO, "src/controllers/audio/sounds/music (1).wav", true));
        setAudioData(new AudioData(WarhammerEnumAudio.BANDAGE, "src/controllers/audio/sounds/Bandaging Sound FX.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.BONECRACK, "src/controllers/audio/sounds/Bone Crack Sound Effect.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.DRAGON, "src/controllers/audio/sounds/Dragon Roar - Free Sound Effect.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.DRINKING, "src/controllers/audio/sounds/Minecraft Drinking Sound Effect.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.EATING, "src/controllers/audio/sounds/Minecraft eating sound effect.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.PILL, "src/controllers/audio/sounds/Pill bottle sound effect.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.POTION, "src/controllers/audio/sounds/Potion #2 (Sound Effect)  Diablo II.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.RAT, "src/controllers/audio/sounds/Rat Sounds Effect.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.SWORD, "src/controllers/audio/sounds/Sword Sharpening Sounds Effects.wav", false));
        setAudioData(new AudioData(WarhammerEnumAudio.WATER, "src/controllers/audio/sounds/Water Flowing Sound Effect.wav", false));

        setAudio(WarhammerEnumAudio.MAIN_AUDIO);
        audioHashMap.get(WarhammerEnumAudio.MAIN_AUDIO).stop();
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