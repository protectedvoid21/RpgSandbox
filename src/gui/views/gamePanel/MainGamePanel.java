package gui.views.gamePanel;

import gui.card.fullCards.abstractCards.Card;
import gui.customComponents.AbstractCustomButton;
import gui.factories.GuiFactory;
import gui.factories.customFactories.buttonFactories.BasicButton;
import gui.menu.ComponentPanelMenager;
import gui.menu.ComponentsSeries;
import gui.menu.DefaultCustomMenuMenager;
import gui.menu.ICustomBackgorund;
import gui.views.BackgroundView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

public class MainGamePanel extends BackgroundView {
    private Color baseBackColor;
    private Color secondBackColor = Color.YELLOW;
    private ComponentPanelMenager generalManager;
    private JPanel panel = new JPanel();
    private OptionsPanel optionsPanel;
//    private DefaultCustomMenuMenager customPanelAttackChoser =
//            new DefaultCustomMenuMenager(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                    ComponentsSeries.ComponentsDimension.VERTICAL, 30);
    private GuiFactory factory;
    private OverlayLayout layout;
    private int maxx;
    private int maxyy;
    public DefaultCustomMenuMenager<AbstractCustomButton> manager =
            new DefaultCustomMenuMenager<AbstractCustomButton>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
                    ComponentsSeries.ComponentsDimension.VERTICAL);

    public MainGamePanel(GuiFactory factory, int x, int y) {
        layout = new OverlayLayout(panel);
        panel.setLayout(layout);
        this.maxx = x;
        this.maxyy = y;
        this.factory = factory;
        optionsPanel = new OptionsPanel(factory, 30);
//        customPanelAttackChoser.addMainComponent(30);
//        customPanelAttackChoser.addMiddleComponent(optionsPanel.getPanel(), 0, 10);
//        customPanelAttackChoser.getCmp().addSpace(10);
        generalManager = new ComponentPanelMenager(panel);
        optionsPanel.initialize(new ArrayList<>(Arrays.asList("src/gui/rightarrowdisabled.png", "src/gui/snowman.png", "src" +
                "/gui/playerimage.png", "src/gui/playerimage.png", "src/gui/monsterimage.png")));
        factory.setButtonFactory(new BasicButton());
        factory.setButtonType(GuiFactory.ButtonType.ICON);
        for (int i = 0; i < x; i++) {
            manager.addMainComponent(5);
            for (int j = 0; j < y; j++) {
                var but = factory.createButton("src/gui/witch.png", null);
                manager.addMiddleComponent(but, i, 5);
                int finalI = i;
                int finalJ = j;
                but.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        addButton(finalI, finalJ);
                    }
                });
            }
        }
        baseBackColor = manager.getMiddleComponent(0,0).getComponent().getBackground();
        panel.add(optionsPanel.getPanel());
        panel.add(manager.getCmp());


//        pane.add(new JButton("Dfdsfs"), 2);


    }

    public void setDisabledIndexes(ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> indexes) {
        for (int i = 0; i < maxx; i++) {
            for (int j = 0; j < maxyy; j++) {
                manager.getMiddleComponent(i, j).getComponent().setEnabled(true);
            }
        }
        for (var index : indexes) {
            manager.getMiddleComponent(index.getKey(), index.getValue()).getComponent().setEnabled(false);
        }

    }

    public void setDisabledIndexes(AbstractMap.SimpleEntry<Integer, Integer>... indexes) {
        setDisabledIndexes(new ArrayList<>(Arrays.asList(indexes)));

    }
    public void colorButtons(AbstractMap.SimpleEntry<Integer, Integer>... indexes) {
        colorButtons(new ArrayList<>(Arrays.asList(indexes)));

    }

    public void colorButtons(ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> indexes){
        for (int i = 0; i < maxx; i++) {
            for (int j = 0; j < maxyy; j++) {
                manager.getMiddleComponent(i, j).getComponent().setBackground(baseBackColor);
            }
        }
        for (var index : indexes) {
            manager.getMiddleComponent(index.getKey(), index.getValue()).getComponent().setBackground(secondBackColor);
        }
    }


    public JPanel getPanel() {
        return generalManager;
    }

    @Override
    protected DefaultCustomMenuMenager getMenager() {
        return manager;
    }

    private void addButton(int xindex, int yindex){
        int leftpercent = (int)(((double)(xindex+0.5)/maxx)*100);
        int rightpercent = 100-30-leftpercent;//30 to waga

        int upprocent = (int)(((double)(yindex+0.5)/maxx)*300);
        int bottomprocent = 300-30-upprocent;

        if (rightpercent<0){
            rightpercent+=30;
            leftpercent-=30;
        }
        if (bottomprocent<0){
             bottomprocent+=30;
             upprocent-=30;
        }
        optionsPanel.getPanel().addSpace(leftpercent, ComponentPanelMenager.Side.LEFT);
        optionsPanel.getPanel().addSpace(rightpercent, ComponentPanelMenager.Side.RIGHT);
        optionsPanel.getPanel().addSpace(upprocent, ComponentPanelMenager.Side.TOP);
        optionsPanel.getPanel().addSpace(bottomprocent, ComponentPanelMenager.Side.BOTTOM);

    }

}
