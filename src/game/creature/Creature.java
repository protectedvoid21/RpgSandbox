package game.creature;

import game.interfaces.IStatistics;

/**So far it doesn't look really nice but in the future we will have some kind of director whose task will be creation of new Creature instance.
 * He creates stats and apply them to this class instance
 * (probably this director will be also able to create equipment so using one factory (builder) class there will be possibility of creating whole object.)*/
public abstract class Creature {
    protected IStatistics statistics;
    protected String name = "Adam";
    protected Position position;
    protected Experience experience;
    
    public Creature(IStatistics statistics, Position position, Experience experience) {
        this.statistics = statistics;//this can be also removed, what about creating new builder which creates required creature for given RPG game, then stats will be created by this builder class.
        this.position = position;
        this.experience = experience;
    }
    
    public void setStatistics(IStatistics statistics) {
        this.statistics = statistics;
    }
    
    public IStatistics getStatistics() {
        return statistics;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    //    public void setPosition(Position position) {
//        this.position = position;
//    }

        public Experience getExperience() {
            return experience;
        }

        public void setExperience(Experience experience) {
            this.experience = experience;
        }


        // cos takiego????
        public void setPosition(int[][] matrix, int x, int y) {
            if ((x >= 0 && x < matrix.length) && (y >= 0 && y > matrix[0].length) && matrix[x][y] == 0 && canOccupy(matrix, x, y)) {
                setPosition(matrix, x, y);
            }
        }

        private boolean canOccupy(int[][] matrix, int x, int y) {
            return true;
        }
}
