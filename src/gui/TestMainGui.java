package gui;

import game.generals.Vector2;
import gui.card.DoubleArrowPanel;
import gui.factories.IOverallFactory;
import gui.factories.WarHammerFactory;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.pickers.CustomLambdaExpression;
import gui.views.pickers.FullItemPicker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.AbstractMap;

public class TestMainGui {
    static Font pixel;

    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();
        var x = f.createMainPanelGame();
        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(2, 3), 2, 4);
        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(2, 5), 1);
        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(1, 3), 3, 4);
        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(1, 3));
        x.getGamePanel().applyContent(new AbstractMap.SimpleEntry<>(new Vector2(3, 4), "src/gui/go.png"));
        x.getPicker(FullItemPicker.LabelType.WEAPON).addListenerToPicker(DoubleArrowPanel.Side.LEFT,
                new CustomLambdaExpression() {
                    @Override
                    public void apply() {
                        System.out.println(x.getPicker(FullItemPicker.LabelType.WEAPON).getCurrentIndex());
                    }
                });

//        ramka.add(f.createCreatingEditingItemsPanel().getPanel());
//        ramka.add(x.getPanel());
//        var z = f.createBasicCard();
//        ((GodCard)z).setItemAction(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("xxx");
//            }
//        });
//        ((GodCard)z).setItemViewStatus(Card.CardTypes.MOUNT, 2);
//        ((GodCard)z).removeItemViewStatus();
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                x.getGamePanel().applyDefendActionsContent(new Vector2(i, j));
            }
        }
        x.getGamePanel().applyAttackActionsContent(new Vector2(2, 1));
        x.getGamePanel().applyAttackActionsContent(new Vector2(2, 1));
        x.getGamePanel().removeActionContent(new Vector2(2, 1), GamePanel.ActionsLabelsType.ATACK);
        x.getGamePanel().applyAttackActionsContent(new Vector2(2, 1));
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                x.getGamePanel().removeActionContent(new Vector2(i, j), GamePanel.ActionsLabelsType.DEFEND);
//            }
//        }
//        x.getGamePanel().setNonVisibleActions();

        ramka.add(x.getPanel());
        var y = f.createAllCreatureShowView();
//        ramka.add(x.getPanel());
//        y.setTitleIncorrect(BaseCard.Side.LEFT, 1555);
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreatorApplyingCharacterView().getPanel());
//        ramka.add(f.createAllCreatureEditView().getPanel());
//        ramka.add(f.createAllItemsShowView().getPanel());
//        ramka.add(f.createAllItemsShowView().getPanel());
//        var pa = f.createGodCard();
//        pa.setItemViewStatus(Card.CardTypes.ARMOR, 3);
//        ramka.add(y.getPanel());
//        ramka.add(f.createCardCancelView(f.createBasicCard()).getPanel());
//        ramka.add(f.createchoosingCreationGameView().getPanel());
//        ramka.add(f.createCreaturesPanel().getPanel());
//        ramka.add(f.createSmallEditItemCard().getPanel());
//        ramka.add(f.createGameCard().getPanel());
//        ramka.add(f.createMenuView().getPanel());
//        ramka.add(f.createViewingItemsPanel().getPanel());
        //       var ff = f.createCreatorGameView();

//         ff.getCreatorPanel().applyNewCreatureOnPosition("aa", new Vector2(2,3));
//        ramka.add(ff.getPanel());
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreaturesPanel().getPanel());
//        ramka.add(f.createCreatorApplyingCharacterView().getPanel());
//        var z = f.createCreatorCard(Card.CreatorTypes.ARMOR);
//        ramka.add(f.createCreatorCard(Card.CreatorTypes.ARMOR).getPanel());
//        ramka.add(f.createBasicCard().getPanel());

        ramka.setVisible(true);
    }
}
