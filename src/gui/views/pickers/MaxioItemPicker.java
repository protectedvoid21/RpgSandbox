package gui.views.pickers;

import gui.bundle.CustomBundle;
import gui.customComponents.abstractComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.data.TextData;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MaxioItemPicker extends ItemPicker implements TextData {
    private final AbstractCustomButton button;
    private ActionListener currentListener = e -> {
    };

    public MaxioItemPicker(GuiFactory factory) {
        super(factory);
        factory.setButtonType(GuiFactory.ButtonType.NORMAL);
        button = factory.createButton(CustomBundle.getDefaultString(useTex), null);
        button.getCustomUI().setOffSet(7);
        menager.addMainComponent(5);
        menager.addMiddleComponent(button, 2, 10);
        menager.getMainComponent(2).addSpace(1);
        button.addActionListener(e -> {
            if (currentSide > -1)
                currentListener.actionPerformed(e);
        });
    }

    public void setButtonEnability(boolean val){
        button.setEnabled(val);
    }
    public void addButtonLIstener(ActionListener listener) {
        currentListener = listener;
    }


    @Override
    public void uploadData(ArrayList<String> dataList) {
        super.uploadData(dataList);
        button.setEnabled(dataList.size() > 0);
    }

}
