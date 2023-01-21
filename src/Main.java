import controllers.ControllerManager;
import game.filehandle.EntityManager;
import gui.factories.WarHammerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager("Warhammer");
        
        ControllerManager controllerManager = new ControllerManager(new WarHammerFactory());
    }
}