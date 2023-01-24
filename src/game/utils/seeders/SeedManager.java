package game.utils.seeders;

import java.util.ArrayList;
import java.util.List;

public class SeedManager implements Seeder {
    private List<Seeder> seeders = new ArrayList<>();
    
    public SeedManager() {
        seeders.add(new ItemSeeder());
        seeders.add(new MonsterSeeder());
        seeders.add(new PlayerSeeder());
        seeders.add(new NPCSeeder());
        seeders.add(new ScenarioSeeder());
    }
    
    @Override
    public void seed() {
        for(var seeder : seeders) {
            seeder.seed();
        }
    }
}
