package game.cardManager.Warhammer;

import game.equipment.Weapon;
import game.equipment.*;
import java.util.ArrayList;

public class InventoryFactory {
    public InventoryFactory() {};

    public Item create(String[] stats) throws Exception
    {
        String type = stats[0], name = stats[1];

        if(type.equals("Armor"))
        {
            String sdamage = stats[2];
            String srange = stats[3];
            String sbleeding = stats[4];
            String spoison = stats[5];
            String sfire = stats[6];
            String sfreezing = stats[7];

            int damage, range, bleeding, poison, fire, freezing;

            damage=Integer.parseInt(sdamage);
            range=Integer.parseInt(srange);
            bleeding=Integer.parseInt(sbleeding);
            poison=Integer.parseInt(spoison);
            fire=Integer.parseInt(sfire);
            freezing=Integer.parseInt(sfreezing);

            return new Weapon(name,damage,range,bleeding,poison,fire,freezing);
        }
        else if(type.equals("Weapon"))
        {
            String sdefence =stats[2];
            int defence = Integer.parseInt(sdefence);

            return new Armor(name,defence);
        }
        else if(type.equals("Mount"))
        {
            String sspeed = stats[2];
            int speed = Integer.parseInt(sspeed);

            return new Mount(name,speed);
        }
        else
        {
            return new Mount("none",0);
        }
    }
}
