package game.interfaces;

import game.generals.AttributeValue;
import game.generals.Effect;

import java.util.ArrayList;

public interface Statistics {

    ArrayList<AttributeValue> createStatistics();
    ArrayList<Effect> createEffects();

}
