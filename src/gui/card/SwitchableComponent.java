package gui.card;

public interface SwitchableComponent {
    void switchSide(DoubleArrowPanel.Side side);

    boolean isSwitchingSidePossible(DoubleArrowPanel.Side side);
}
