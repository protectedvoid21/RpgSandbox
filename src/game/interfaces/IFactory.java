package game.interfaces;

import game.cardManager.Warhammer.DecodeArrayStatisticsWarhammer;
import game.creature.Creature;

import java.util.ArrayList;

public abstract class IFactory {

    public static ArrayList<Integer> errorIndexes = new ArrayList<>();
    public static boolean errorFlag = false;
    public static boolean nameError = false;
    public static boolean pathError = false;

    public abstract Creature creat(ArrayList<String> stats);

    public static void resetErrorFlags() {
        errorFlag = false;
        nameError = false;
        pathError = false;
        errorIndexes.clear();
    }

    protected void setErrors( String name, String path){
        if(!errorFlag){
            errorFlag = DecodeArrayStatisticsWarhammer.errorFlag;
        }
        errorIndexes = DecodeArrayStatisticsWarhammer.errorIndexes;
        System.out.println(errorIndexes);
        if(name.isEmpty()){
            System.out.println(errorFlag+"tututu4");
            errorFlag = true;
            nameError = true;
        }
        if(path.isEmpty()){
            System.out.println(errorFlag+"tututu3");
            errorFlag = true;
            pathError = true;
        }
    }
}
