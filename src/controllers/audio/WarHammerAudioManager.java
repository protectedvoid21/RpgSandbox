package controllers.audio;

public class WarHammerAudioManager extends CustomAudioManager {

    @Override
    public void setAudio(ICustomEnumAudio audio)  {

        super.setAudio(audio);
        if (audio != WarhammerEnumAudio.MAIN_AUDIO) {
            currentRunAudio.setActivityOnStop(() -> {
                    setAudio(WarhammerEnumAudio.MAIN_AUDIO);

            });
        }
    }
}
