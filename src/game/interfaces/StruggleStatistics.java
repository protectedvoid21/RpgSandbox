package game.interfaces;

import game.board.RoundManager;
import game.generals.AttributeValue;

import java.util.HashMap;
import java.util.Map;

public class StruggleStatistics implements IStruggleStatistics, RoundListener {
    protected Map<IStruggleAtributeEnum, AttributeValue> struggleAttributes = new HashMap<>();

    public StruggleStatistics() {
        initializeStruggleStatistics();
    }

    protected void initializeStruggleStatistics() {}

    @Override
    public AttributeValue getAttribute(IStruggleAtributeEnum iStruggleAtributeEnum) {
        return(struggleAttributes.get(iStruggleAtributeEnum));
    }

    @Override
    public void applyNewRound() {

    }
}
