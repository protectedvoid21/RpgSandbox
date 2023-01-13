package game.cardManager.Warhammer;

import game.equipment.Weapon;
import game.equipment.*;
import java.util.ArrayList;

public class InventoryFactory {
    public InventoryFactory() {};

    public Item create(ArrayList<String> stats) throws Exception
    {
        String type = stats.get(0), name = stats.get(1);

        if(type.equals("Armor"))
        {
            String sdamage = stats.get(2);
            String srange = stats.get(3);
            String sbleeding = stats.get(4);
            String spoison = stats.get(5);
            String sfire = stats.get(6);
            String sfreezing = stats.get(7);

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
            String sdefence = stats.get(2);
            int defence = Integer.parseInt(sdefence);

            return new Armor(name,defence);
        }
        else if(type.equals("Mount"))
        {
            String sspeed = stats.get(2);
            int speed = Integer.parseInt(sspeed);

            return new Mount(name,speed);
        }
        else
        {
            return new Mount("none",0);
        }
    }
}
