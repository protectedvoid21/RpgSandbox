package game.interfaces;

import game.generals.AttributeValue;

public interface IStruggleStatistics extends RoundListener{

    AttributeValue getAttribute(IStruggleAtributeEnum iStruggleAtributeEnum);
}
