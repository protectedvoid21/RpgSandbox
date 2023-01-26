package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.equipment.Item;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import gui.views.pickers.FullItemPicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EndTurnListener implements ActionListener {

    RoundManager roundManager;
    MainPanelGame mainPanelGame;

    public EndTurnListener(RoundManager roundManager, MainPanelGame mainPanelGame) {
        this.roundManager = roundManager;
        this.mainPanelGame = mainPanelGame;
        method();
        method2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        roundManager.moveToNextObject();
        mainPanelGame.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
        turnOffButtons.turnOff(roundManager, mainPanelGame, 2, 0);
        method();
        method2();


    }

    private void uploadPicker(FullItemPicker.LabelType type, List<? extends Item> items, Item activeItem) {
        var array = new ArrayList<String>();
        for (var item : items) {
            array.add(item.getItemPathPicture());
        }
        mainPanelGame.getPicker(type).uploadData(array);
        mainPanelGame.getPicker(type).setCurrentIndex(items.
                indexOf(activeItem));
    }

    private void method() {
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var character = (Character) roundManager.getGameObjectWithTurn().getCreature();

            uploadPicker(FullItemPicker.LabelType.MOUNT, character.getInventory().getMounts(),
                    character.getInventory().getActiveMount());
            uploadPicker(FullItemPicker.LabelType.ARMOR, character.getInventory().getArmors(),
                    character.getInventory().getActiveArmor());
            uploadPicker(FullItemPicker.LabelType.MOUNT, character.getInventory().getWeapons(),
                    character.getInventory().getActiveWeapon());

            var array = new ArrayList<String>();
            for (var item : character.getInventory().getMounts()) {
                array.add(item.getItemPathPicture());
            }
            var array1 = new ArrayList<String>();
            for (var item : character.getInventory().getWeapons()) {
                array1.add(item.getItemPathPicture());
            }
            var array2 = new ArrayList<String>();
            for (var item : character.getInventory().getArmors()) {
                array2.add(item.getItemPathPicture());
            }
            mainPanelGame.getPicker(FullItemPicker.LabelType.MOUNT).uploadData(array);
            mainPanelGame.getPicker(FullItemPicker.LabelType.MOUNT).setCurrentIndex(character.getInventory().getMounts().
                    indexOf(character.getInventory().getActiveMount()));
            mainPanelGame.getPicker(FullItemPicker.LabelType.WEAPON).uploadData(array1);
            mainPanelGame.getPicker(FullItemPicker.LabelType.WEAPON).setCurrentIndex(character.getInventory().getWeapons().
                    indexOf(character.getInventory().getActiveWeapon()));

            mainPanelGame.getPicker(FullItemPicker.LabelType.ARMOR).uploadData(array2);
            mainPanelGame.getPicker(FullItemPicker.LabelType.ARMOR).setCurrentIndex(character.getInventory().getArmors().
                    indexOf(character.getInventory().getActiveArmor()));


        }
    }

    private void method2() {
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var character = (Character) roundManager.getGameObjectWithTurn().getCreature();
            var array = new ArrayList<String>();
            for (var item : character.getInventory().getDisposableItems()) {
                array.add(item.getItemPathPicture());
            }
            mainPanelGame.getItemsItemPicker().uploadData(array);
            mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));


        }
    }
}
