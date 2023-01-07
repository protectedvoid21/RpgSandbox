package gui.card;

import gui.customComponents.IContentCustomUICmp;
import gui.customUI.interfaces.ICustomUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Components have to be written using same font style, only can differ in font size(which will be optimized)
 */
public class SharedCmpsFont<T extends JComponent &IContentCustomUICmp> {//cos ogarnac z metoda maksymalna font i array lista
    private ArrayList<T> cmps = new ArrayList<>();


    public SharedCmpsFont(T... cmps) {
        for (var cmp : cmps) {
            this.cmps.add(cmp);
        }
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
//            System.out.println(newFontSize+ " "+cmp.isVisible());
            if (newFontSize < min && cmp.isVisible()) {
                min = newFontSize;
            }
        }
//        System.out.println("koniec"+min);
        return min;
    }

    public void setSharedFontSize(JComponent component, String text) {
        var size = getMinFont();
        for (var cmp : cmps) {
            if (cmp.hasSharedSize()) {
                cmp.setFont(size);
            }
        }
        for (var cmp : cmps) {
//            System.out.println(component.getFont()+"   "+component);
        }
    }

    public static void setUniformFont(ArrayList<? extends IContentCustomUICmp>... elements) {
        setUniformFont(new ArrayList<>(Stream.of(elements).flatMap(x -> x.stream()).collect(Collectors.toList())));
    }

    public static void setUniformFont(ArrayList<? extends IContentCustomUICmp> elements) {
        var sharecmpfont = new SharedCmpsFont(elements);
        for (var cmpUI : elements) {
            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
        }
    }

}
