package game.equipment;

import game.generals.AttributeValue;

import java.util.HashMap;
import java.util.Map;

public abstract class Item {
    protected Map<String, AttributeValue> attributes = new HashMap<>();
}
