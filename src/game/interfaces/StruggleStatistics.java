package game.interfaces;

import game.generals.AttributeValue;

import java.util.HashMap;
import java.util.Map;

public class StruggleStatistics implements IStruggleStatistics {
    protected Map<IStruggleAtributeEnum, AttributeValue> struggleAttributes = new HashMap<>();

    public StruggleStatistics() {
        initializeStruggleStatistics();
    }

    protected void initializeStruggleStatistics() {}

    @Override
    public AttributeValue getAttribute(IStruggleAtributeEnum iStruggleAtributeEnum) {
        return(struggleAttributes.get(iStruggleAtributeEnum));
    }
}
