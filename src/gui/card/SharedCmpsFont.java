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
public class SharedCmpsFont<T extends IContentCustomUICmp> {//cos ogarnac z metoda maksymalna font i array lista
    private ArrayList<T> cmps = new ArrayList<>();


    public SharedCmpsFont(T... cmps) {
        for (var cmp : cmps) {
            this.cmps.add(cmp);
        }
    }

    public SharedCmpsFont(ArrayList<T> cmps) {
        this.cmps = cmps;
    }

//    private IContentCustomUICmp getLeader(){
//        return cmps.size()>0?cmps.get(0):null;
//    }

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

    public void setSharedFontSize(JComponent component, String text) {//zrobic cos co aby ostatnia instancje sprawdzi
//        if (getLeader() == component) {
        var size = getMinFont();
        for (var cmp : cmps) {
            if (cmp.hasSharedSize()) {
                cmp.setFont(size);
            }
        }
//        }
    }

    public static void setUniformFont(ArrayList<? extends IContentCustomUICmp>... elements) {
        setUniformFont(new ArrayList<>(Stream.of(elements).flatMap(x -> x.stream()).collect(Collectors.toList())));
    }

    public static void setUniformFont(ArrayList<? extends IContentCustomUICmp> elements) {
//        ArrayList<IContentCustomUICmp> cmpsUIs = new ArrayList<>();
//        var mngrLst = getContentMenager().getComponentsList();
//
//        for (var cmp : mngrLst) {
//            cmpsUIs.add((IContentCustomUICmp) cmp);
//        }
//        var sharecmpfont = new SharedCmpsFont(cmpsUIs);
//        for (var cmpUI : cmpsUIs) {
//            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
//        }


        var sharecmpfont = new SharedCmpsFont(elements);
        for (var cmpUI : elements) {
            cmpUI.getCustomUI().setSharedComponentSize(sharecmpfont);
        }
    }

}
