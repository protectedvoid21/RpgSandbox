package gui.card;

import gui.customComponents.ITextCustomUICmp;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Components have to be written using same font style, only can differ in font size(which will be optimized)
 */
public class SharedCmpsFont<T extends ITextCustomUICmp> {//cos ogarnac z metoda maksymalna font i array lista
    private ArrayList<T> cmps = new ArrayList<>();


    public SharedCmpsFont(T... cmps) {
        for (var cmp : cmps) {
            this.cmps.add(cmp);
        }
    }

    public SharedCmpsFont(ArrayList<T> cmps) {
        this.cmps = cmps;
    }

    private ITextCustomUICmp getLeader(){
        return cmps.size()>0?cmps.get(0):null;
    }

    public void removeComponentFromList(JComponent component) {
        cmps.remove(component);
    }

    private int getMinFont() {
        var min = cmps.get(0).getMaximumPossibleFontSize();
        for (var cmp : cmps) {
            var newFontSize = cmp.getMaximumPossibleFontSize();
            if (newFontSize < min) {
                min = newFontSize;
            }
        }
        return min;
    }

    public void setSharedFontSize(JComponent component, String text) {
        if (getLeader() == component) {
            var size = getMinFont();
            for (var cmp : cmps) {
                if (cmp.hasSharedSize()) {
                    cmp.setFont(size);
                }
            }
        }
    }
}
