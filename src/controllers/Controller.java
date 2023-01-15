package controllers;

public abstract class Controller {
    protected ControllerManager controllerManager;

    public Controller(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    public abstract void render();
}
