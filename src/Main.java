import game.creature.Creature;
import game.interfaceWarhammer.AttributeEnum;
import game.interfaceWarhammer.DependantEnum;

public class Main {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.getStatistic().getAttribute(AttributeEnum.STRENGTH.name()).setValue(52);
        System.out.println(creature.getStatistic().getDependantAttrValue(DependantEnum.STRENGTH_BONUS.name()));
    }
}