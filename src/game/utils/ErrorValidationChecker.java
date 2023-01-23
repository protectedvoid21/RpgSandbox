package game.utils;

import game.cardManager.Warhammer.DecodeArrayStatisticsWarhammer;
import game.creature.Creature;

import java.util.ArrayList;

public class ErrorValidationChecker {
    private static ArrayList<Integer> errorIndexes = new ArrayList<>();
    private boolean errorFlag = false;
    private boolean nameError = false;
    private boolean pathError = false;


    public void resetErrorFlags() {
        errorFlag = false;
        nameError = false;
        pathError = false;
        errorIndexes.clear();
    }

//    protected void setErrors(String name, String path) {
//        if (!errorFlag) {
//            errorFlag = DecodeArrayStatisticsWarhammer.isErrorFlag();
//        }
//        errorIndexes = DecodeArrayStatisticsWarhammer.getErrorIndexes();
//        if (name.isEmpty()) {
//            setNameErrorOnTrue();
//        }
//        if (path.isEmpty()) {
//            setPathErrorOnTrue();
//        }
//    }

    public void addIntexToErrorList(int value){
        this.errorFlag =true;
        errorIndexes.add(value);
    }

    public void setErrorIndexes(ArrayList<Integer> list){
        errorIndexes = list;
        if(!list.isEmpty() && !errorFlag){
            errorFlag = true;
        }
    }

    public void setNameErrorOnTrue() {
        this.errorFlag =true;
        this.nameError = true;
    }

    public void setPathErrorOnTrue() {
        this.errorFlag =true;
        this.pathError = true;
    }

    public ArrayList<Integer> getErrorIndexes() {
        return errorIndexes;
    }

    public boolean isErrorFlag() {
        return errorFlag;
    }

    public boolean isNameError() {
        return nameError;
    }

    public boolean isPathError() {
        return pathError;
    }
}
