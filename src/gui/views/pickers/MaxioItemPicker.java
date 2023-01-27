package gui.views.pickers;

import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MaxioItemPicker extends ItemPicker {
    private final AbstractCustomButton button;
    private ActionListener currentListener = e -> {
    };

    public MaxioItemPicker(GuiFactory factory) {
        super(factory);
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        button = factory.createButton("USE", null);
        button.getCustomUI().setOffSet(7);
        menager.addMainComponent(5);
        menager.addMiddleComponent(button, 2, 10);
        menager.getMainComponent(2).addSpace(1);
        button.addActionListener(e -> {
            if (currentSide > -1)
                currentListener.actionPerformed(e);
        });
    }
    public void addButtonLIstener(ActionListener listener) {
        currentListener = listener;
    }

    @Override
    public void uploadData(ArrayList<String> dataList) {
        super.uploadData(dataList);
        button.setEnabled(dataList.size() > 0);
    }

    public void addButtonListener(ActionListener listener) {
        button.addActionListener(listener);
    }
}
