package gui.customUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public abstract class CustomUI implements ICustomUI {

    private JComponent parent;
    private HashMap<ICustomUI.Index, Color> additionalColors = new HashMap<>();

    public void installUI(JComponent c) {
        parent = c;
        c.setOpaque(false);
        c.setBorder(new EmptyBorder(1, 1, 1, 1));
    }

    public void setAdditionaldColor(Color color, ICustomUI.Index index) {
        additionalColors.put(index, color);
    }

    public Color getAdditionalColor(ICustomUI.Index index) {
        return additionalColors.get(index) != null ? additionalColors.get(index) : additionalColors.get(Index.BASE_BACKGROUND);
    }


}
