package game.interfaces;

import game.cardManager.Warhammer.DecodeArrayStatisticsWarhammer;
import game.creature.Creature;
import game.utils.ErrorValidationChecker;

import java.util.ArrayList;

public abstract class IFactory {

    protected static ErrorValidationChecker errorValidationChecker = new ErrorValidationChecker();

    public abstract Creature creat(ArrayList<String> stats);

    public static ErrorValidationChecker getErrorValidationChecker() {
        return errorValidationChecker;
    }
    protected void setErrors(String name, String path, ArrayList<Integer> indexes){
        if(name.isEmpty()){
            errorValidationChecker.setNameErrorOnTrue();
        }
        if(path.isEmpty()){
            errorValidationChecker.setPathErrorOnTrue();
        }
        errorValidationChecker.setErrorIndexes(indexes);
    }
}
