package game.generals;

public class AttributeValue {

    private int value;
    private int leftRangeValue;
    private int rightRangeValue;

    public AttributeValue(int leftValue, int rightValue, int startValue){ //limits are included to the range
        if (leftValue<rightValue){
            leftRangeValue = leftValue;
            rightRangeValue = rightValue;
        }else{
            leftRangeValue = rightValue;
            rightRangeValue = leftValue;
        }
        value = startValue;
    }

    public AttributeValue(int startValue){
        leftRangeValue = 0;
        rightRangeValue = 100;
        value = startValue;

    }

    public int getValue(){
        return value;
    }
    public void increaseValue(int valueChange){
        setValue(value+valueChange);
    }

    public void decreaseValue(int valueChange){
        setValue(value-valueChange);
    }

    public void setValue(int newValue){
        value = newValue;
        if(value>rightRangeValue){
            value = rightRangeValue;
        }
        if (value<leftRangeValue){
            value = leftRangeValue;
        }
    }

}
