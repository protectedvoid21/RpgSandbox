//package gui.views.gamePanel;
//
//import gui.factories.GuiFactory;
//import gui.menu.DefaultCustomMenuMenager;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public abstract class ContentGamePanel {
//    protected int size;
//    protected GuiFactory factory;
//    public ContentGamePanel(int size, GuiFactory factory){
//        this.size = size;
//        this.factory = factory;
//        for (int i = 0; i < size; i++) {
//            getManager().addMainComponent(5);
//            for (int j = 0; j < size; j++) {
//                var but = factory.createLabel("src/gui/witch.png");
////                but.setHasDisabledColor(true);
////                but.setSecondDisabledColor(Color.YELLOW);
//                getManager().addMiddleComponent(createBaseComponent(), i, 5);
//                int finalI = i;
//                int finalJ = j;
//                but.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        if (optionsPanel.getCurrentX() != finalI || optionsPanel.getCurrentY() != finalJ) {
//                            addButton(finalI, finalJ);
//                            optionsPanel.setCurrentIndexes(finalI, finalJ);
//                        }else{
//                            optionsPanel.setVisible(false);
//                        }
//                    }
//                });
//            }
//        }
//
//    }
//
//    public abstract DefaultCustomMenuMenager<? extends JComponent> getManager();
//    public abstract JComponent createBaseComponent();
//}
