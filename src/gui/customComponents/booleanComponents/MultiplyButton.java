package gui.customComponents.booleanComponents;

import gui.customComponents.abstractComponents.AbstractCustomButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MultiplyButton extends AbstractCustomButton {

    private ArrayList<String> strings = new ArrayList<>();
    private int value = 0;
    private ArrayList<ActionListener> listeners = new ArrayList<>();

    public MultiplyButton() {
        super();
        addActionListener(e -> {
            if (listeners.size() != 0) {
                moveValue();
                setText(strings.get(value));
                listeners.get((value-1)<0?listeners.size()-1:value-1).actionPerformed(e);
            }
        });
    }

    public void setListeners(ArrayList<String> strings, ArrayList<ActionListener> actionListener) {
        this.listeners = actionListener;
        this.strings = strings;

    }

    public int getIndex(){
        return value;
    }

    public void setIndex(int index){
        while(this.value!=index){
            moveValue();
        }
        setText(strings.get(value));
    }


    private void moveValue() {
        value++;
        if (value >= listeners.size()) {
            value = 0;
        }
    }

    @Override
    public void setContent(String text) {
        strings.set(value, text);
        setText(strings.get(value));
    }

    @Override
    public String getContent() {
        return strings.get(value);
    }


}
