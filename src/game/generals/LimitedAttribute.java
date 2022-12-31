package game.generals;

import com.owlike.genson.annotation.JsonIgnore;
import com.owlike.genson.annotation.JsonProperty;

/**Class which purpose is to control unlimited attribute value
 * User has to set it between two specified values (included to range). */
public class LimitedAttribute extends AttributeValue {

    protected int rightRangeValue;
    public LimitedAttribute(@JsonProperty("leftRangeValue") int leftValue,
                            @JsonProperty("rightRangeValue") int rightValue, 
                            @JsonProperty("value") int startValue){
        if (leftValue<rightValue){
            leftRangeValue = leftValue;
            rightRangeValue = rightValue;
        }else{
            leftRangeValue = rightValue;
            rightRangeValue = leftValue;
        }
        setValue(startValue);
    }

    public LimitedAttribute(int startValue){
        leftRangeValue = 0;
        rightRangeValue = 100;
        setValue(startValue);
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
