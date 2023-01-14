package gui.margin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/**
 * Class used for setting margin of text. Actually it is empty border but class contain some methods which make it
 * simpler.
 */
public class ComponentTextMarginManager {
    private JComponent component;

    private ArrayList<MarginAction> onMarginCheckedActions = new ArrayList<>();

    public enum Side {LEFT, TOP, RIGHT, BOTTOM}

    private HashMap<Side, AbstractMap.SimpleEntry<Double, Double>> marginPercentMap = new HashMap<>();

    public ComponentTextMarginManager(JComponent component) {
        this.component = component;
        set(0, 0, 0, 0);
    }

    public void reset() {
        set(getPercentValue(Side.TOP), getPercentValue(Side.LEFT), getPercentValue(Side.BOTTOM),
                getPercentValue(Side.RIGHT));
    }

    public void addActionOnMarginChecked(MarginAction runnable){
        onMarginCheckedActions.add(runnable);
    }


    public void checkValidation() {
        var top = getPercentValue(Side.TOP);
        var left = getPercentValue(Side.LEFT);
        var bottom = getPercentValue(Side.BOTTOM);
        var right = getPercentValue(Side.RIGHT);
        var newBorder = new HashMap<Side, Double>();
        newBorder.put(Side.LEFT, left * component.getWidth() / 100);
        newBorder.put(Side.RIGHT, right * component.getWidth() / 100);
        newBorder.put(Side.BOTTOM, bottom * component.getHeight() / 100);
        newBorder.put(Side.TOP, top * component.getHeight() / 100);
        for (var k : newBorder.keySet()) {
            if (newBorder.get(k) != get(k)) {
                set(top, left, bottom, right);
                for (var action : onMarginCheckedActions){
                    action.run();
                }
                return;
            }
        }


    }


    public double get(Side side) {
        return marginPercentMap.get(side).getValue();
    }

    public double getPercentValue(Side side) {
        return marginPercentMap.get(side).getKey();
    }


    public void remove(){
        set(0,0,0,0);
    }

    public void set(double top, double left, double bottom, double right) {
        var h = component.getHeight();
        var w = component.getWidth();
        var absTop = h * top / 100;
        var absBottom = h * bottom / 100;
        var absLeft = w * left / 100;
        var absRight = w * right / 100;
        var margin = new EmptyBorder((int) absTop, (int) absLeft, (int) absBottom, (int) absRight);

        initializeMarginPercentMapPart(Side.LEFT, left, absLeft);
        initializeMarginPercentMapPart(Side.RIGHT, right, absRight);
        initializeMarginPercentMapPart(Side.BOTTOM, bottom, absBottom);
        initializeMarginPercentMapPart(Side.TOP, top, absTop);
        component.setBorder(margin);
    }

    private void initializeMarginPercentMapPart(Side side, double value, double componentSize) {
        marginPercentMap.put(side, new AbstractMap.SimpleEntry<>(value, componentSize));
    }


    public void set(Side side, double value) {
        switch (side) {
            case TOP ->
                    set(value, getPercentValue(Side.LEFT), getPercentValue(Side.BOTTOM), getPercentValue(Side.RIGHT));
            case LEFT ->
                    set(getPercentValue(Side.TOP), value, getPercentValue(Side.BOTTOM), getPercentValue(Side.RIGHT));
            case BOTTOM ->
                    set(getPercentValue(Side.TOP), getPercentValue(Side.LEFT), value, getPercentValue(Side.RIGHT));
            case RIGHT ->
                    set(getPercentValue(Side.TOP), getPercentValue(Side.LEFT), getPercentValue(Side.BOTTOM), value);
        }
    }

}
