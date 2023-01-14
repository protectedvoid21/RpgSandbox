package game.interfaceWarhammer;

import game.generals.LimitedAttribute;
import game.generals.UnlimitedAttribute;
import game.interfaces.StruggleStatistics;

public class StruggleStatisticsWarhammer extends StruggleStatistics {

    public StruggleStatisticsWarhammer() {
        super();
    }


    public void initializeStruggleStatistics() {
        struggleAttributes.put(StruggleAtributeEnum.ACTIONS_TO_DO, new LimitedAttribute(0,2,2));
        struggleAttributes.put(StruggleAtributeEnum.IS_BLOKING, new LimitedAttribute(0,1,0));
        struggleAttributes.put(StruggleAtributeEnum.IS_AIMING, new LimitedAttribute(0,1,0));
        struggleAttributes.put(StruggleAtributeEnum.IS_IN_DEFENSE_STAND, new LimitedAttribute(0,1,0));
    };
}
