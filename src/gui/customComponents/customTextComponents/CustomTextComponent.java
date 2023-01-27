package gui.customComponents.customTextComponents;

import gui.customComponents.AbstractCustomLabel;
import gui.customComponents.CustomLabel;
import gui.customComponents.IContentCustomUICmp;
import gui.customUI.componentsUIs.CustomLabelUI;
import gui.customUI.customUIStyles.RoundedBorderUI;
import gui.customUI.interfaces.ICustomUI;
import gui.factories.GuiFactory;
import gui.margin.ComponentTextMarginManager;
import gui.margin.IComponentTextMargin;
import gui.margin.MarginAction;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base abstract class for CustomTextField and CustomTextArea classes.
 */
public class CustomTextComponent extends JPanel implements IComponentTextMargin, IContentCustomUICmp {


    private int counter = 0;
    private OverlayLayout layout = new OverlayLayout(this);
    protected JTextComponent textField;
    private AbstractCustomLabel label = new TextComponentLabel() {
        @Override
        public void setText(String text) {
            super.setText(text);
        }
    };
    private ComponentTextMarginManager margin;
    private ComponentAdapter adapter = new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            setRelevantFont();
            super.componentResized(e);
            setRelevantFont();
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            super.componentMoved(e);
            setRelevantFont();
        }

        @Override
        public void componentShown(ComponentEvent e) {
            super.componentShown(e);
            setRelevantFont();
        }

        @Override
        public void componentHidden(ComponentEvent e) {
            super.componentHidden(e);
            counter = 0;
        }
    };

    public CustomTextComponent() {
        setLayout(layout);
        setOpaque(false);
    }

    protected void addComponentsToPanel() {
        var panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        add(textField);
        panel.add(label, BorderLayout.CENTER);
        add(panel);

    }

    @Override
    public void setVisible(boolean aFlag) {
        counter = 0;
        super.setVisible(aFlag);
    }

    protected void initializeTextField() {
        textField.setFont(new Font(textField.getFont().getName(), Font.PLAIN, textField.getFont().getSize()));
        label.setFont(new Font(textField.getFont().getName(), Font.PLAIN, textField.getFont().getSize()));
        margin = new ComponentTextMarginManager(textField);
        textField.addComponentListener(adapter);
        label.addComponentListener(adapter);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        addComponentListener(adapter);


        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setRelevantFont();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setRelevantFont();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setRelevantFont();
            }
        });
        textField.setOpaque(false);
        textField.setPreferredSize(new Dimension(1, 1));
        textField.setBorder(new EmptyBorder(0, 0, 0, 0));
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
    protected void paintComponent(Graphics g) {
        setRelevantFont();
        super.paintComponent(g); var f = label.getCustomUI().getRelevantFont(label.getText());
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
    public ComponentTextMarginManager getMargin() {
        return label.getMargin();
    }

    @Override
    public void setBackground(Color bg) {
        if (label != null) {
            label.setBackground(bg);
        }
        super.setBackground(bg);
    }

    public void setListener(CustomDocumentListener listener) {
        listener.setLabel(label);
        listener.setTextComponent(textField);
        textField.getDocument().addDocumentListener(listener);
    }

    @Override
    public ICustomUI getCustomUI() {
        return label.getCustomUI();
    }

    @Override
    public String getContent() {
        return textField.getText();
    }

    @Override
    public void setContent(String newContent) {
        textField.setText(newContent);
        label.setContent(newContent);

    }

    @Override
    public int getMaximumPossibleFontSize() {
        return label.getMaximumPossibleFontSize();
    }


    @Override
    public void setFont(Font font) {
        if (label != null && textField != null) {
            label.setFont(new Font(font.getName(), font.getStyle(),
                    font.getSize()));
            textField.setFont(new Font(font.getName(), font.getStyle(),
                    font.getSize()));
        }
        super.setFont(font);
    }

    @Override
    public void setFont(int newFontSize) {
        textField.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), newFontSize));
        label.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(), newFontSize));
    }


    public void setMaximumFontSize(boolean value) {
        label.setMaximumFontSizeStatus(value);
    }


    @Override
    public boolean hasSharedSize() {
        return label.hasSharedSize();
    }

    public Font getFieldFont() {
        return textField.getFont();
    }

    protected void setRelevantFont() {
        for (var side : ComponentTextMarginManager.Side.values()) {
            margin.set(side, label.getCustomUI().getCurrentActivatedMargin().getPercentValue(side));
        }
            label.setContent(textField.getText());
//        var f = label.getCustomUI().getRelevantFont(label.getText());
//        for (var cmp : Arrays.asList(textField, label)){
//            cmp.setFont(new Font(label.getFont().getName(), label.getFont().getStyle(),
//                    f.getSize()));
//        }
        setFont( label.getCustomUI().getRelevantFont(label.getText()).getSize());
    }

    public void setMaximumFontRelevantToHeight(boolean value) {
        label.getCustomUI().setFontRelevantToHeight(value);
    }
}
