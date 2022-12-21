package gui.factories;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class Animation {
    enum State {
        ENTERED, EXITED, PRESSED, RELEASED
    }

    private State state;

    private JComponent component;

    Animation(JComponent component) {
        this.component = component;
        state = State.EXITED;
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                component.setBackground(Color.ORANGE);
                state = State.ENTERED;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                component.setBackground(Color.BLUE);
                state = State.EXITED;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                component.setBackground(Color.GREEN);
                state = State.PRESSED;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                component.setBackground(Color.BLUE);
                state = State.RELEASED;
            }
        });
    }

    public void paint(Graphics grphcs) {
        switch (state){
            case EXITED, RELEASED -> grphcs.setColor(Color.BLUE);
            case PRESSED -> grphcs.setColor(Color.GREEN);
            case ENTERED -> grphcs.setColor(Color.ORANGE);
        }
        grphcs.fillRect(0, 0, component.getWidth(), component.getHeight());
    }

    protected void paint2(Graphics g) {
        g.setColor(component.getForeground());
        g.drawOval(0, 0, component.getSize().width-1,
                component.getSize().height-1);
    }
}
