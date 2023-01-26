package game.equipment.examples;

import game.board.Board;
import game.board.GameObject;
import game.board.Scenario;
import game.equipment.DisposableItem;
import game.generals.Vector2;
import gui.factories.WarhammerData;

import java.util.List;

import static game.interfaceWarhammer.AttributeEnum.HEALTH_POINTS_NOW;

public class HolyHandGrenadeofAntioch extends DisposableItem implements WarhammerData {
    private int range;

    public HolyHandGrenadeofAntioch( int usageCount) {
        super( usageCount);
        range = 2;setItemPathPicture(grenadePath);

        description = "And Saint Attila raised the hand grenade up on high, saying, 'O Lord, bless this thy hand grenade, that with it thou mayst blow thine enemies to tiny bits, in thy mercy.' And the Lord did grin. And the people did feast upon the lambs, and sloths, and carp, and anchovies, and orangutans, and breakfast cereals, and fruit bats, and large chulapas. And the Lord spake, saying, 'First shalt thou take out the Holy Pin. Then shalt thou count to three, no more, no less. Three shall be the number thou shalt count, and the number of the counting shall be three. Four shalt thou not count, neither count thou two, excepting that thou then proceed to three. Five is right out. Once the number three, being the third number, be reached, then lobbest thou thy Holy Hand Grenade of Antioch towards thy foe, who, being naughty in My sight, shall snuff it.";
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
