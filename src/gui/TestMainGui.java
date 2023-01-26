package gui;

import game.creature.Experience;
import game.creature.Monster;
import game.equipment.Armor;
import game.equipment.Inventory;
import game.equipment.Mount;
import game.equipment.Weapon;
import game.generals.Vector2;
import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaceWarhammer.StruggleStatisticsWarhammer;
import gui.card.DoubleArrowPanel;
import gui.card.fullCards.abstractCards.Card;
import gui.factories.IOverallFactory;
import gui.factories.WarHammerFactory;
import gui.utils.Converter;
import gui.views.gamePanel.gamePanels.GamePanel;
import gui.views.pickers.CustomLambdaExpression;
import gui.views.pickers.FullItemPicker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;

public class TestMainGui {
    static Font pixel;

    public static void main(String[] args) throws IOException {
        JFrame ramka = new JFrame();
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(800, 800);
        IOverallFactory f = new WarHammerFactory();
        var x = f.createMainPanelGame();
//        x.getGamePanel().applyAttackActionsContent(new Vector2(3,4));
        ramka.add(x.getPanel());
//        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(2, 3), 2, 4);
//        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(2, 5), 1);
//        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(1, 3), 3, 4);
//        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(1, 3));
//        x.getGamePanel().applyContent(new AbstractMap.SimpleEntry<>(new Vector2(3, 4), "src/gui/go.png"));
//        x.getPicker(FullItemPicker.LabelType.WEAPON).addListenerToPicker(DoubleArrowPanel.Side.LEFT,
//                new CustomLambdaExpression() {
//                    @Override
//                    public void apply() {
//                        System.out.println(x.getPicker(FullItemPicker.LabelType.WEAPON).getCurrentIndex());
//                    }
//                });

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
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 4));
//        x.getGamePanel().applyDefendActionsContent(new Vector2(2, 5));
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                x.getGamePanel().applyDefendActionsContent(new Vector2(i, j));
//            }
//        }
//        x.getGamePanel().applyAttackActionsContent(new Vector2(2, 1));
//        x.getGamePanel().applyAttackActionsContent(new Vector2(2, 1));
//        x.getGamePanel().removeActionContent(new Vector2(2, 1), GamePanel.ActionsLabelsType.ATACK);
//        x.getGamePanel().applyAttackActionsContent(new Vector2(2, 1));
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                x.getGamePanel().removeActionContent(new Vector2(i, j), GamePanel.ActionsLabelsType.DEFEND);
//            }
//        }
//        x.getGamePanel().setNonVisibleActions();
//
//        ramka.add(x.getPanel());
//        var y = f.createAllWeaponsItemsView();
//        var title = f.createTitleView();
//        title.initialize("HELLO world", y);
//        var god = f.createGodCard();
//        god.setItemViewStatus(Card.CardTypes.ITEMS, 2);
//        ramka.add(f.createMainPanelGame().getPanel());
//        var card = f.createBasicCard();
//
//        Weapon weapon = new Weapon("weapon1", 100, 10);
//        Mount mount = new Mount("horse1", 20);
//        Mount mount1 = new Mount("horse2", 30);
//        Mount mount2 = new Mount("horse3", 40);
//        Armor armor = new Armor("armor1", 45);
//        Inventory inventory = new Inventory();
//        inventory.addItem(weapon);
//        inventory.addItem(mount);
//        inventory.addItem(mount1);
//        inventory.addItem(mount2);
//        inventory.addItem(armor);
//        Monster playerCharacter = new Monster(new StatisticsWarhammer(),
//                new Experience(10), new StruggleStatisticsWarhammer());
//        playerCharacter.setName("Shgjehrk");
//        playerCharacter.setObjectPathPicture("/src/gui/playerimage.png");
//
//        card.uploadNewData(Converter.createFullDataCreature(playerCharacter), Converter
//        .createFullDetailDataCreature(playerCharacter));
//        ramka.add(f.createGameCard().getPanel());
////        y.setTitleIncorrect(BaseCard.Side.LEFT, 1555);
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreatorApplyingCharacterView().getPanel());
//       ramka.add(f.createAllCreatureEditView().getPanel());
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

//        ramka.add(ff.getPanel());
//        ramka.add(f.createAllCreatureShowView().getPanel());
//        ramka.add(f.createCreaturesPanel().getPanel());
//        var x = f.createCreatorApplyingCharacterView();

//        ramka.add(x.getPanel());
//        x.getGamePanel().changeActiveOptionsPanel();
//        x.getGamePanel().setOptionsDisabledIndexes(new Vector2(1, 2), 1);
//        x.getGamePanel().changeActiveOptionsPanel();
//        x.resizeGamePanel(true);
//        x.getGamePanel().changeActiveOptionsPanel();
//        x.getGamePanel().changeActiveOptionsPanel();

//        ramka.add(f.createBasicCard().getPanel());
//        ramka.add(f.createOverallItemPanel().getPanel());
//        ramka.add(f.createchoosingCreationGameView().getPanel());
        ramka.setVisible(true);
    }
}
