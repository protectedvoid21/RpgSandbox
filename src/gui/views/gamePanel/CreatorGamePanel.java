//package gui.views.gamePanel;
//
//import gui.card.IOverallFactory;
//import gui.card.fullCards.abstractCards.Card;
//import gui.customComponents.AbstractCustomButton;
//import gui.factories.GuiFactory;
//import gui.factories.customFactories.buttonFactories.BasicButton;
//import gui.menu.ComponentPanelMenager;
//import gui.menu.ComponentsSeries;
//import gui.menu.DefaultCustomMenuMenager;
//import gui.views.BackgroundView;
//import gui.views.gamePanel.optionsPanels.OptionsPanel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.AbstractMap;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class CreatorGamePanel extends BackgroundView {
//    private Color baseBackColor;
//    public enum ActionsLabelsType {ATACK, DEFEND}
////    private HashMap<ActionsLabelsType, IconLabel> actionsMap = new HashMap<>();
//    private Color secondBackColor = Color.YELLOW;
//    private ComponentPanelMenager generalManager;
//    private JPanel panel = new JPanel();
//    private OptionsPanel optionsPanel;//ale inny
//    private IOverallFactory factory;//
//    private OverlayLayout layout;//
//    private int maxIndex;
//    final private int weight;//
//    public DefaultCustomMenuMenager<AbstractCustomButton> manager =
//            new DefaultCustomMenuMenager<AbstractCustomButton>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
//                    ComponentsSeries.ComponentsDimension.VERTICAL);//
////    public DefaultCustomMenuMenager<AbstractCustomLabel> managerActions =
////            new DefaultCustomMenuMenager<AbstractCustomLabel>(ComponentsSeries.ComponentsDimension.HORIZONTAL,
////                    ComponentsSeries.ComponentsDimension.VERTICAL);
//
//    public CreatorGamePanel(IOverallFactory factory, int size) {
//        layout = new OverlayLayout(panel);
//        this.weight = 400 / size;
//        panel.setLayout(layout);
//        this.maxIndex = size;
//        this.factory = factory;
////        optionsPanel = factory.createOptionsPanel();
//        optionsPanel.initialize(weight);
//        optionsPanel.setBorderColor(Color.RED);
//        generalManager = new ComponentPanelMenager(panel, 60);
//        generalManager.addSpace(1);
//        panel.setOpaque(false);
//        generalManager.setBackground(new Color(0xA25F5F));
//        generalManager.setHasUniqueColor(true);
//        intiializeOptionsPanelData(new ArrayList<>(Arrays.asList(new AbstractMap.SimpleEntry<>("src/gui" +
//                        "/rightarrowdisabled.png",
//                        "2"), new AbstractMap.SimpleEntry<>("src/gui/snowman.png", "0"),
//                new AbstractMap.SimpleEntry<>("/gui/playerimage.png", "1"), new AbstractMap.SimpleEntry<>(
//                        "src/gui/playerimage.png", "2"), new AbstractMap.SimpleEntry<>(
//                        "src/gui/playerimage.png", "3"))));
////        optionsPanel.setNonVisibleButtons(1,3);
//        factory.getFactory().setButtonFactory(new BasicButton());
//        factory.getFactory().setButtonType(GuiFactory.ButtonType.ICON);
//        factory.getFactory().setLabelType(GuiFactory.LabelType.ICON);
//        for (int i = 0; i < maxIndex; i++) {
//            manager.addMainComponent(5);
//            for (int j = 0; j < maxIndex; j++) {
//                var but = factory.getFactory().createButton("src/gui/witch.png", null);
//                but.setHasDisabledColor(true);
//                but.setSecondDisabledColor(Color.YELLOW);
//                manager.addMiddleComponent(but, i, 5);
//                int finalI = i;
//                int finalJ = j;
//                but.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (optionsPanel.getCurrentPoint().x != finalI || optionsPanel.getCurrentPoint().y != finalJ) {
//                            addButton(finalI, finalJ);
//                            optionsPanel.setCurrentIndexes(finalI, finalJ);
//                        } else {
//                            optionsPanel.setVisible(false);
//                        }
//                    }
//                });
//            }
//        }
//
//        manager.getMiddleComponent(maxIndex - 1, maxIndex - 1).getComponent().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                removeContent();
//            }
//        });
////        for (int i = 0; i < maxIndex; i++) {
////            managerActions.addMainComponent(5);
////            for (int j = 0; j < maxIndex; j++) {
////                managerActions.addMiddleComponent(new IconLabel(Card.EMPTY_DATA_CONTENT), i, 5);
////                managerActions.getMiddleComponent(i, j).addSpace(5);
////            }
////        }
//        baseBackColor = manager.getMiddleComponent(0, 0).getComponent().getBackground();
////        panel.add(managerActions.getCmp());
//        addPanels();
//    }
//
////    public void setAttackArmorPathContent(String armorPath, String attackPath) {
////        actionsMap.put(ActionsLabelsType.DEFEND, new IconLabel(armorPath));
////        actionsMap.put(ActionsLabelsType.ATACK, new IconLabel(attackPath));
////    }
//
//    protected void addPanels(){
//        panel.add(optionsPanel.getPanel());
//        panel.add(manager.getCmp());
//    }
//
//    public void removeContent() {
//        for (int i = 0; i < maxIndex; i++) {
//            for (int j = 0; j < maxIndex; j++) {
//                var button = manager.getMiddleComponent(i, j).getComponent();
//                button.setContent(Card.EMPTY_DATA_CONTENT);
//                if (!button.isEnabled()) {
//                    button.setEnabled(true);
//                }
//            }
//        }
//    }
//
////    public void removeActionsContent() {
////        for (int i = 0; i < maxIndex; i++) {
////            for (int j = 0; j < maxIndex; j++) {
////                managerActions.getMiddleComponent(i, j).getComponent().setContent(Card.EMPTY_DATA_CONTENT);
////
////            }
////        }
////    }
//
////    public void applyDefendActionsContent(Point position) {
////        helpMethodActionsChangeContent(position, ActionsLabelsType.DEFEND);
////    }
////
////    public void applyAttackActionsContent(Point position) {
////        helpMethodActionsChangeContent(position, ActionsLabelsType.ATACK);
////    }
////
////    private void helpMethodActionsChangeContent(Point position, ActionsLabelsType type) {
////        if (!position.isOutOfRange(maxIndex, maxIndex)) {
////            var pos = managerActions.getMiddleComponent(position.x, position.y);
////            var label = pos.getComponent();
////            pos.changeContent(actionsMap.get(type));
////            var t = new javax.swing.Timer(1500, e -> pos.changeContent(label));
////            t.start();
////        }
////
////    }
//
//
//    public void applyContent(ArrayList<AbstractMap.SimpleEntry<Point, String>> content) {
//        for (var pair : content) {
//            manager.getMiddleComponent(pair.getKey().x, pair.getKey().y).getComponent().setContent(pair.getValue());
//        }
//    }
//
//    public void intiializeOptionsPanelData(ArrayList<AbstractMap.SimpleEntry<String, String>> optionsPanelData) {
////        optionsPanel.ini(optionsPanelData);
//    }
//
//
//    public void addOptionsListener(int index, ActionListener listener) {
//        optionsPanel.addOptionsPanelCommand(index, listener);
//    }
//
//    public Point getCurrentClickedIndexes() {
//        return optionsPanel.getCurrentPoint();
//    }
//
//    public void setOptionsDisabledIndexes(ArrayList<Integer> indexes) {
//        optionsPanel.setDisabledIndexes(indexes);
//    }
//
//    public void setOptionsDisabledIndexes(Integer... indexes) {
//        optionsPanel.setDisabledIndexes(indexes);
//    }
//
//    public void setDisabledIndexes(ArrayList<Point> indexes) {
//        for (int i = 0; i < maxIndex; i++) {
//            for (int j = 0; j < maxIndex; j++) {
//                manager.getMiddleComponent(i, j).getComponent().setEnabled(true);
//            }
//        }
//        for (var index : indexes) {
//            if (!index.isOutOfRange(maxIndex, maxIndex)) {
//                manager.getMiddleComponent(index.x, index.y).getComponent().setEnabled(false);
//            }
//        }
//
//    }
//
//    public void setDisabledIndexes(Point... indexes) {
//        setDisabledIndexes(new ArrayList<>(Arrays.asList(indexes)));
//
//    }
//
//    public void colorButtons(Point... indexes) {
//        colorButtons(new ArrayList<>(Arrays.asList(indexes)));
//
//    }
//
//    public void colorButtons(ArrayList<Point> indexes) {
//        for (int i = 0; i < maxIndex; i++) {
//            for (int j = 0; j < maxIndex; j++) {
//                manager.getMiddleComponent(i, j).getComponent().setBackground(baseBackColor);
//            }
//        }
//        for (var index : indexes) {
//            if (!index.isOutOfRange(maxIndex, maxIndex)) {
//                manager.getMiddleComponent(index.x, index.y).getComponent().setBackground(secondBackColor);
//            }
//        }
//    }
//
//
//    public JPanel getPanel() {
//        return generalManager;
//    }
//
//    @Override
//    protected DefaultCustomMenuMenager getMenager() {
//        return manager;
//    }
//
//    private void addButton(int xindex, int yindex) {
//        optionsPanel.getPanel().setVisible(true);
//        var changeX = optionsPanel.getPercentFilledSizeX();
//        var changeY = optionsPanel.getPercentFilledSizeY();
//        int leftpercent = (int) (((double) (xindex + 0.5) / maxIndex) * 100 / changeX);
//        int rightpercent = (int) (100 / changeX) - weight - leftpercent;//30 to waga
//
//        int upprocent = (int) (((double) (yindex + 0.5) / maxIndex) * 300/changeY);
//        int bottomprocent = (int) (300/changeY) - weight - upprocent;
//
//        if (rightpercent < 0) {
//            rightpercent += weight;
//            leftpercent -= weight;
//        }
//        if (bottomprocent < 0) {
//            bottomprocent += weight;
//            upprocent -= weight;
//        }
//        optionsPanel.getPanel().addSpace(leftpercent, ComponentPanelMenager.Side.LEFT);
//        optionsPanel.getPanel().addSpace(rightpercent, ComponentPanelMenager.Side.RIGHT);
//        optionsPanel.getPanel().addSpace(upprocent, ComponentPanelMenager.Side.TOP);
//        optionsPanel.getPanel().addSpace(bottomprocent, ComponentPanelMenager.Side.BOTTOM);
//
//    }
//
//}
