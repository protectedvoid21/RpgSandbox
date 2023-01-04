//package gui.card;
//
//import gui.customComponents.AbstractCustomButton;
//import gui.factories.GuiFactory;
//import gui.menu.ComponentPanelMenager;
//
//public class GameCancelCard extends GameCard implements ICancelCard{
//    private AbstractCustomButton cancelButton;
//
//    public GameCancelCard(GuiFactory factory) {
//        super(factory);
//        seriesPanel.addMainComponent(1);
//        cancelButton = factory.createButton("CANCEL", e -> seriesPanel.getCmp().setVisible(false));
//        seriesPanel.addMiddleComponent(cancelButton, 3, 10);
//        seriesPanel.getMiddleComponent(3, 0).addSpace(10, ComponentPanelMenager.Side.LEFT,
//                ComponentPanelMenager.Side.RIGHT);
//    }
//
//    @Override
//    public AbstractCustomButton getCancelButton() {
//        return cancelButton;
//    }
//    }
//}
