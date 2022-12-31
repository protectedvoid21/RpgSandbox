package game.generals;

import com.owlike.genson.annotation.JsonProperty;

/**Class which purpose is to control unlimited attribute value
 * User cannot set it below some specified value(included to range). */
public class UnlimitedAttribute extends AttributeValue {

    public UnlimitedAttribute(@JsonProperty("leftRangeValue")int leftValue, 
                              @JsonProperty("value") int startValue){ //limit included to the range
        leftRangeValue = leftValue;
        setValue(startValue);
    }

    public UnlimitedAttribute(int startValue){
        leftRangeValue = 0;
        setValue(startValue);
    }

    public void setValue(int newValue){
        value = newValue;
        if (value<leftRangeValue){
            value = leftRangeValue;
        }
    }
}
