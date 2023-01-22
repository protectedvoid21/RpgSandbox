package game.interfaces;

import game.cardManager.Warhammer.DecodeArrayStatisticsWarhammer;
import game.creature.Creature;

import java.util.ArrayList;

public abstract class IFactory {

    private static ArrayList<Integer> errorIndexes = new ArrayList<>();
    private static boolean errorFlag = false;
    private static boolean nameError = false;
    private static boolean pathError = false;

    public abstract Creature creat(ArrayList<String> stats);

    public static void resetErrorFlags() {
        errorFlag = false;
        nameError = false;
        pathError = false;
        errorIndexes.clear();
    }

    protected void setErrors( String name, String path){
        if(!errorFlag){
            errorFlag = DecodeArrayStatisticsWarhammer.isErrorFlag();
        }
        errorIndexes = DecodeArrayStatisticsWarhammer.getErrorIndexes();
        if(name.isEmpty()){
            errorFlag = true;
            nameError = true;
        }
        if(path.isEmpty()){
            errorFlag = true;
            pathError = true;
        }
    }

    public static ArrayList<Integer> getErrorIndexes() {
        return errorIndexes;
    }

    public static boolean isErrorFlag() {
        return errorFlag;
    }

    public static boolean isNameError() {
        return nameError;
    }

    public static boolean isPathError() {
        return pathError;
    }
}
