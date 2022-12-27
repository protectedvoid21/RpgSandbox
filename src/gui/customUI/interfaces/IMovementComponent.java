package gui.customUI.interfaces;

import gui.customUI.interfaces.IRequieredReactionOnMovementComponent;


public interface IMovementComponent {

    enum Direction {HORIZONTAL, VERTICAL}

    void notifyComponents(int offSetValue);

    void addComponent(IRequieredReactionOnMovementComponent component);
}
