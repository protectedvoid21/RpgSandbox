package gui.views.gamePanel;

import gui.customComponents.AbstractCustomButton;
import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.iconComponents.IconButton;
import gui.customComponents.iconComponents.IconLabel;
import gui.factories.GuiFactory;
import gui.utils.StringAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Dice {
    private ArrayList<String> arrayList;
    private AbstractCustomButton button;

    public Dice(GuiFactory factory) {
        arrayList = new ArrayList<>(Arrays.asList(StringAdapter.getRelativePath("dice1.png"),
                StringAdapter.getRelativePath("dice2.png"), StringAdapter.getRelativePath("dice3.png"),
                StringAdapter.getRelativePath("dice4.png"), StringAdapter.getRelativePath("dice5.png"),
                StringAdapter.getRelativePath("dice6.png")));
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        button = factory.createButton(arrayList.get(0), null);
        button.getCustomUI().setOffSet(0);
        button.getCustomUI().setBackGroundTransparent(true);

    }

    public void setNumber(int value) {
        button.setContent(arrayList.get(value - 1));
    }

    public void block() {
        button.setEnabled(false);
    }

    public void unblock() {
        button.setEnabled(true);
    }

    public JButton getDice() {
        return button;
    }
}
