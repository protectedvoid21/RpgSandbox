package gui.customUI.customUIStyles;

import javax.swing.*;
import java.awt.*;

public abstract class BorderUI extends CustomUI{
    final private int offSet;

    public BorderUI(int offSet) {
        this.offSet = offSet;
    }

    public BorderUI() {
        this(6);
    }


    @Override
    public void paint(Graphics g, JComponent c) {
        paintBackground(g, c, offSet);
    }

    @Override
    public int getBorderSize() {
        return offSet;
    }
}
