package gui.views.utilsViews;

import gui.customUI.customUIStyles.borderStrategies.AverageBorderStartegy;
import gui.menu.DefaultCustomMenuMenager;
import gui.menu.ICustomBackgorund;

import java.awt.*;
import java.io.IOException;

public abstract class BackgroundView implements ICustomBackgorund {

    protected abstract DefaultCustomMenuMenager getMenager();

    @Override
    public void setBackgroundImage(String path) {
        try {
            getMenager().getCmp().setBackgroundImage(path);
        } catch (IOException e) {
            setBackground(new Color(0x935D3A));
        }
    }

    @Override
    public void setBackground(Color color) {
        getMenager().setBackground(color);
    }

    public void setBorder(Color color, int value){
        getMenager().getCmp().setBorderData(color, new AverageBorderStartegy(), value);
    }
}
