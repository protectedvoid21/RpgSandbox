package gui.actionListener.warhammerActions;

import game.generals.Vector2;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.pickers.CustomLambdaExpression;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class BaseAttackAction implements ActionListener {
    public void dotTimeActivity(int time, ActionListener exp) {
        var timer = new Timer(time, exp);
        timer.setRepeats(false);
        timer.start();
    }
}
