package game.utils.seeders;

import game.creature.Experience;
import game.creature.NPC;
import game.equipment.Inventory;
import game.filehandle.EntityManager;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;

public class NPCSeeder implements Seeder{
    @Override
    public void seed() {
        NPC npc1 = new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        npc1.setName("Alan");
        NPC npc2 = new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        npc2.setName("Brian");
        NPC npc3 = new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        npc3.setName("Krzys");
        NPC npc4 = new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        npc4.setName("Seba");
        NPC npc5 = new NPC(new StatisticsWarhammer(), new Inventory(), new Experience(0), new StruggleStatisticsWarhammer());
        npc5.setName("Wojtek");

        EntityManager.getInstance().addCreature(npc1);
        EntityManager.getInstance().addCreature(npc2);
        EntityManager.getInstance().addCreature(npc3);
        EntityManager.getInstance().addCreature(npc4);
        EntityManager.getInstance().addCreature(npc5);
    }
}
