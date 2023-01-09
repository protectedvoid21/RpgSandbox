package gui.views;

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
}
