import controllers.ControllerManager;
import gui.factories.WarHammerFactory;

public class Main {
    public static void main(String[] args) {
        ControllerManager controllerManager = new ControllerManager(new WarHammerFactory());
    }
}