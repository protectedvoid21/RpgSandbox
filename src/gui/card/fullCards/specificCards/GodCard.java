package gui.card.fullCards.specificCards;

import gui.factories.GuiFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GodCard extends BasicCard{
    public GodCard(GuiFactory factory) {
        super(factory);
    }
    private ActionListener itemAction = e -> {
    };

    public void setItemViewStatus(CardTypes type, int index){
        switchSide(type);
        if (type != CardTypes.OVERALL && type != CardTypes.ATTRIBUTE) {
            detailButtonMethod(null, type, index);
        }
        setListener(itemAction);
    }

    public void removeItemViewStatus(){
        methodOfRightDownPanelComponent();
        switchSide(CardTypes.OVERALL);
        setListener(e->methodOfRightDownPanelComponent());
    }
    private void setListener(ActionListener listener){
        for (var lst : exitButton.getComponent().getActionListeners()){
            exitButton.getComponent().removeActionListener(lst);
        }
        exitButton.getComponent().addActionListener(listener);
    }

    public void setItemAction(ActionListener listener){
        this.itemAction = listener;
    }

}
