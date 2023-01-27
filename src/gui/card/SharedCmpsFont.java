package gui.card;

import gui.customComponents.IContentCustomUICmp;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Components have to be written using same font style, only can differ in font size(which will be optimized)
 */
public class SharedCmpsFont<T extends JComponent &IContentCustomUICmp> {
    private ArrayList<T> cmps = new ArrayList<>();
    public SharedCmpsFont(T... cmps) {
        this.cmps.addAll(Arrays.asList(cmps));
    }

    public SharedCmpsFont(ArrayList<T> cmps) {
        this.cmps = cmps;
    }


    public void removeComponentFromList(JComponent component) {
        cmps.remove(component);
    }

    private int getMinFont() {
        var min = 10000;
        for (var cmp : cmps) {
            var newFontSize = cmp.getMaximumPossibleFontSize();
            if (newFontSize < min && cmp.isVisible()) {
                min = newFontSize;
            }
        }
        return min;
    }

    public void setSharedFontSize() {
        var size = getMinFont();
        for (var cmp : cmps) {
            if (cmp.hasSharedSize()) {
                cmp.setFont(size);
            }
        }
    }

    public static void setUniformFont(ArrayList<? extends IContentCustomUICmp>... elements) {
        setUniformFont(new ArrayList<>(Stream.of(elements).flatMap(Collection::stream).collect(Collectors.toList())));
    }

    public static void setUniformFont(ArrayList<? extends IContentCustomUICmp> elements) {
        var sharecmpfont = new SharedCmpsFont(elements);
        for (var cmpUI : elements) {
            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
        }
    }

}
