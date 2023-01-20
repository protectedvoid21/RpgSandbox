package game.equipment.examples;

import game.board.Board;
import game.board.GameObject;
import game.board.Scenario;
import game.equipment.DisposableItem;
import game.generals.Vector2;

import java.util.List;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class HolyHandGrenadeofAntioch extends DisposableItem {
    private int range;

    public HolyHandGrenadeofAntioch(int usageCount) {
        super(usageCount);
        range = 2;
    }

    public int getRange() {
        return range;
    }

    public void use(int x, int y, Board board) {
        super.use();

        if(x>0)
        {
            if(y>0)
            {
                if(!board.getPlace(new Vector2(x-1,y-1)).isEmpty())
                {
                    board.getPlace(new Vector2(x-1,y-1)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
                }
            }

            if(!board.getPlace(new Vector2(x-1,y)).isEmpty())
            {
                board.getPlace(new Vector2(x-1,y)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
            }

            if(y< board.getHeight())
            {
                if(!board.getPlace(new Vector2(x-1,y+1)).isEmpty())
                {
                    board.getPlace(new Vector2(x-1,y+1)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
                }
            }
        }


        if(y>0)
        {
            if(!board.getPlace(new Vector2(x,y-1)).isEmpty())
            {
                board.getPlace(new Vector2(x,y-1)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
            }
        }

        if(!board.getPlace(new Vector2(x,y)).isEmpty())
        {
            board.getPlace(new Vector2(x,y)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
        }

        if(y< board.getHeight())
        {
            if(!board.getPlace(new Vector2(x,y+1)).isEmpty())
            {
                board.getPlace(new Vector2(x,y+1)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
            }
        }


        if(x< board.getWidth())
        {
            if(y>0)
            {
                if(!board.getPlace(new Vector2(x+1,y-1)).isEmpty())
                {
                    board.getPlace(new Vector2(x+1,y-1)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
                }
            }

            if(!board.getPlace(new Vector2(x+1,y)).isEmpty())
            {
                board.getPlace(new Vector2(x+1,y)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
            }

            if(y< board.getHeight())
            {
                if(!board.getPlace(new Vector2(x+1,y+1)).isEmpty())
                {
                    board.getPlace(new Vector2(x+1,y+1)).getGameObject().getCreature().getStatistics().getAttribute(HEALTH_POINTS_NOW).decreaseValue(3);
                }
            }
        }
    }
}
