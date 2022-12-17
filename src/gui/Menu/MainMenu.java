package gui.Menu;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;

public class MainMenu extends JPanel {
    JPanel restPanel;
    GridBagLayout restLayout;
    GridBagConstraints cst;

    public MainMenu(Container parent) {
        super();
        int horizontalMargin = (int) (parent.getSize().width * 0.25);
        int verticalMargin = (int) (parent.getSize().height * 0.125);
        setBorder(BorderFactory.createEmptyBorder(verticalMargin, horizontalMargin, verticalMargin, horizontalMargin));

        var lay = new BorderLayout();
        setBackground(Color.BLUE);
        System.out.println(getMinimumSize());
        lay.setVgap((int) (0.125 * parent.getSize().height));
        setLayout(lay);

        cst = new GridBagConstraints();
        restPanel = new JPanel();
        restPanel.setBackground(Color.ORANGE);
        restLayout = new GridBagLayout();
        restPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        add(restPanel, BorderLayout.CENTER);
        restPanel.setLayout(restLayout);


        cst.gridx = 0;
        cst.fill = GridBagConstraints.BOTH;
        cst.weightx = 10;

        cst.gridy = 0;
        cst.weighty = 20;
        restPanel.add(Box.createVerticalBox(), cst);

        cst.gridy = 1;
        cst.weighty = 10;
        restPanel.add(new JButton("xxxx"), cst);

        cst.gridy = 2;
        cst.weighty = 20;
        restPanel.add(Box.createVerticalBox(), cst);

        cst.gridy = 3;
        cst.weighty = 10;
        restPanel.add(new JButton("xxsdfxx"), cst);

        cst.gridy = 4;
        cst.weighty = 20;
        restPanel.add(Box.createVerticalBox(), cst);

        cst.gridy = 5;
        cst.weighty = 10;
        restPanel.add(new JButton("xfsdfsxxx"), cst);

        cst.gridy = 6;
        cst.weighty = 20;
        restPanel.add(Box.createVerticalBox(), cst);


        setTitle("HELLOOfsfjsdjgfsdjgjsdgjsdjgfdsjfsdjfjsdfj");
        parent.add(this);
    }

    public void addOption(String name) {
//        var rowsNumber = restLayout.getRows();
//        System.out.println(rowsNumber);
//        if (rowsNumber!=0){
//            restLayout.setRows(rowsNumber + 1);
//        }
        var button = new JButton(name);
        restPanel.add(button);
        System.out.println(button.getSize());
        System.out.println(button.getPreferredSize());
        System.out.println(restLayout.minimumLayoutSize(button));
        System.out.println(restLayout.preferredLayoutSize(button));
        restLayout.preferredLayoutSize(button);

        if (restPanel.getComponents().length != 1) {
            var value = 200 / (restPanel.getComponents().length - 1);
//            restLayout.setVgap(value);
//            restPanel.setBorder(BorderFactory.createEmptyBorder(value, 50, value, 50));
//            restPanel.getBorder().getBorderInsets(restPanel).set(value/3, 0, value/3, 0);
        }
//        System.out.println(restLayout.getVgap());
    }

    public void setTitle(String name) {
        var label = new JLabel(name);
        label.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBackground(Color.ORANGE);
        label.setPreferredSize(new Dimension(0, 60));
        add(label, BorderLayout.NORTH);
    }
}
