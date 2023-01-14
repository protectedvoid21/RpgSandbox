package game.interfaceWarhammer;

import game.board.GameObject;
import game.interfaces.ICreatureOrder;
import game.interfaceWarhammer.AttributeEnum.*;
import game.struggle.Dice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static game.interfaceWarhammer.AttributeEnum.*;

public class CreatureOrder implements ICreatureOrder {
    @Override
    public ArrayList<GameObject> sort(ArrayList<GameObject> gameObjects) {
        for(int i = 0; i < gameObjects.size(); i++){
            for(int j = 1; j < gameObjects.size(); j++){
                if(gameObjects.get(j - 1).getCreature().getStatistics().getAttribute(AGILITY).getValue()< gameObjects.get(j).getCreature().getStatistics().getAttribute(AGILITY).getValue()){
                 Collections.swap(gameObjects,j-1,j);
                }
            }
        }

        return gameObjects;
    }
}
