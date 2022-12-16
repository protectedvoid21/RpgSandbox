package game.generals;

public abstract class AttributeValue {
    protected int value;
    protected int leftRangeValue;
    
    public int getValue(){
        return value;
    }
    
    public void increaseValue(int valueChange){
        setValue(value+valueChange);
    }

    public void decreaseValue(int valueChange){
        setValue(value-valueChange);
    }

    public abstract void setValue(int valueChanged);
}
