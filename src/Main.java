import controllers.ControllerManager;
import game.filehandle.EntityManager;
import game.utils.seeders.SeedManager;
import game.utils.seeders.Seeder;
import gui.factories.WarHammerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager("Warhammer");
        Seeder seeder = new SeedManager();
        //seeder.seed();
        //entityManager.saveAllEntities();
        
        ControllerManager controllerManager = new ControllerManager(new WarHammerFactory());
    }
}