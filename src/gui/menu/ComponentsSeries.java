package gui.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ComponentsSeries<T extends JComponent> extends JPanel {

    public enum ComponentsDimension {VERTICAL, HORIZONTAL}
    private GridBagConstraints mainCst = new GridBagConstraints();
    private ArrayList<T> componentsList = new ArrayList<>();
    private ComponentsDimension dimension;

    public ComponentsSeries(ComponentsDimension dimension) {
        super();

        setLayout(new GridBagLayout());
        this.dimension = dimension;
        mainCst.fill = GridBagConstraints.BOTH;
        initializeCst(0, 0, 10, 10);
    }

    private void initializeCst(int gridx, int gridy, double weightx, double weighty) {
        mainCst.gridx = gridx;
        mainCst.gridy = gridy;
        mainCst.weightx = weightx;
        mainCst.weighty = weighty;
    }

    public void addOption(T component, double weight) {
        component.setPreferredSize(new Dimension(1, 1));
        switch (dimension) {
            case VERTICAL -> initializeCst(0, componentsList.size(), mainCst.weightx, weight);
            case HORIZONTAL -> initializeCst(componentsList.size(), 0, weight, mainCst.weighty);
        }
        componentsList.add(component);
        add(component, mainCst);
    }

    public T getOption(int index) {
        return componentsList.get(index);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (componentsList != null) {
            for (var cmp : componentsList) {
                if (cmp instanceof JPanel) {
                    cmp.setBackground(bg);
                }
            }
        }
    }
}
