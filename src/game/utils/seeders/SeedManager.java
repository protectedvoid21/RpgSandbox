package game.utils.seeders;

import java.util.ArrayList;
import java.util.List;

public class SeedManager implements Seeder {
    private List<Seeder> seeders = new ArrayList<>();
    
    public SeedManager() {
        seeders.add(new MonsterSeeder());
        //add more seeders
    }
    
    @Override
    public void seed() {
        for(var seeder : seeders) {
            seeder.seed();
        }
    }
}
