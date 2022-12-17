package game.generals;

public class EffectAttribute extends UnlimitedAttribute {


    public EffectAttribute() {
        super(0);
    }
    public EffectAttribute(int startValue) {
        super(startValue);
    }

    public boolean isActive() {
        return getValue() != 0;
    }

}
