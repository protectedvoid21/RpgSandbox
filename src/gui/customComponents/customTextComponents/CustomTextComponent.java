package gui.customComponents.customTextComponents;

import gui.customComponents.CustomLabel;
import gui.customUI.CustomLabelUI;
import gui.customUI.ICustomUI;
import gui.margin.ComponentTextMarginMenager;
import gui.margin.IComponentTextMargin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class CustomTextComponent extends JPanel implements IComponentTextMargin {
    private OverlayLayout layout = new OverlayLayout(this);
    protected JTextComponent textField;
    private CustomLabel label = new CustomLabel();
   private ComponentTextMarginMenager margin;

    public CustomTextComponent() {
        setLayout(layout);
    }

    protected void addComponentsToPanel(){
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(textField);
        panel.add(label, BorderLayout.CENTER);
        add(panel);

    }

    protected void initializeTextField(){
        margin = new ComponentTextMarginMenager(textField);
        textField.setOpaque(false);
        textField.setPreferredSize(new Dimension(1, 1));
        textField.setBorder(new EmptyBorder(1, 1, 1, 1));
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for (var listener : label.getMouseListeners()) {
                    listener.mouseClicked(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                for (var listener : label.getMouseListeners()) {
                    listener.mousePressed(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                for (var listener : label.getMouseListeners()) {
                    listener.mouseReleased(e);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                for (var listener : label.getMouseListeners()) {
                    listener.mouseEntered(e);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                for (var listener : label.getMouseListeners()) {
                    listener.mouseExited(e);
                }
            }
        });
    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }

    public void setUI(ICustomUI ui) {
        label.setUI(new CustomLabelUI(ui));
    }

    public JTextComponent getTextComponent() {
        return textField;
    }

    @Override
    public ComponentTextMarginMenager getMargin() {
        return margin;
    }

    @Override
    public void setBackground(Color bg) {
        if (label != null) {
            label.setBackground(bg);
        }
    }
}
