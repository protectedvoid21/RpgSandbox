package game.creature;

import game.interfaces.Statistics;

/**So far it doesn't look really nice but in the future we will have some kind of director whose task will be creation of new Creature instance.
 * He creates stats and apply them to this class instance
 * (probably this director will be also able to create equipment so using one factory (builder) class there will be possibility of creating whole object.)*/
public abstract class Creature {
    protected Statistics statistics;

    public Creature(Statistics creatureStats) {
        statistics = creatureStats;//this can be also removed, what about creating new builder which creates required creature for given RPG game, then stats will be created by this builder class.
    }

    public Statistics getStatistic() {
        return statistics;
    }
}
