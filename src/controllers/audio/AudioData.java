package controllers.audio;

public class AudioData {
    public ICustomEnumAudio enumName;
    public String audio;
    public boolean loop;

    public AudioData(ICustomEnumAudio enumName, String audio, boolean loop) {
        this.enumName = enumName;
        this.audio = audio;
        this.loop = loop;
    }
}
