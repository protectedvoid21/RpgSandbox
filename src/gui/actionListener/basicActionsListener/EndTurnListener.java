package gui.actionListener.basicActionsListener;

import game.board.RoundManager;
import game.creature.Character;
import game.equipment.Item;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;
import gui.views.pickers.FullItemPicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EndTurnListener implements ActionListener {

    final private RoundManager roundManager;
    final private MainPanelGame mainPanelGame;

    public EndTurnListener(ListenerBaseData listenerBaseData) {
        this.roundManager = listenerBaseData.roundManager;
        this.mainPanelGame =listenerBaseData. mainPanelGame;
        itemGenerator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        roundManager.moveToNextObject();
        mainPanelGame.getGamePanel().colorButtons(roundManager.getGameObjectWithTurnPosition());
        turnOffButtons.turnOff(roundManager, mainPanelGame, 2, 0);
        itemGenerator();

    }

    private void uploadPicker(FullItemPicker.LabelType type, List<? extends Item> items, Item activeItem) {
        var array = generatePathsArrayList(items);
        mainPanelGame.getPicker(type).uploadData(array);
        mainPanelGame.getPicker(type).setCurrentIndex(items.
                indexOf(activeItem));
    }

    private void itemGenerator() {
        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
            var character = (Character) roundManager.getGameObjectWithTurn().getCreature();

            uploadPicker(FullItemPicker.LabelType.MOUNT, character.getInventory().getMounts(),
                    character.getInventory().getActiveMount());
            uploadPicker(FullItemPicker.LabelType.ARMOR, character.getInventory().getArmors(),
                    character.getInventory().getActiveArmor());
            uploadPicker(FullItemPicker.LabelType.MOUNT, character.getInventory().getWeapons(),
                    character.getInventory().getActiveWeapon());
            var array = generatePathsArrayList(character.getInventory().getDisposableItems());
            mainPanelGame.getItemsItemPicker().uploadData(array);
            mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));

//            var array = new ArrayList<String>();
//            for (var item : character.getInventory().getMounts()) {
//                array.add(item.getItemPathPicture());
//            }
//            var array1 = new ArrayList<String>();
//            for (var item : character.getInventory().getWeapons()) {
//                array1.add(item.getItemPathPicture());
//            }
//            var array2 = new ArrayList<String>();
//            for (var item : character.getInventory().getArmors()) {
//                array2.add(item.getItemPathPicture());
//            }
//            mainPanelGame.getPicker(FullItemPicker.LabelType.MOUNT).uploadData(array);
//            mainPanelGame.getPicker(FullItemPicker.LabelType.MOUNT).setCurrentIndex(character.getInventory().getMounts().
//                    indexOf(character.getInventory().getActiveMount()));
//            mainPanelGame.getPicker(FullItemPicker.LabelType.WEAPON).uploadData(array1);
//            mainPanelGame.getPicker(FullItemPicker.LabelType.WEAPON).setCurrentIndex(character.getInventory().getWeapons().
//                    indexOf(character.getInventory().getActiveWeapon()));
//
//            mainPanelGame.getPicker(FullItemPicker.LabelType.ARMOR).uploadData(array2);
//            mainPanelGame.getPicker(FullItemPicker.LabelType.ARMOR).setCurrentIndex(character.getInventory().getArmors().
//                    indexOf(character.getInventory().getActiveArmor()));


        }
    }

//    private void disItemGenerator() {
//        if (roundManager.getGameObjectWithTurn().getCreature() instanceof Character) {
//            var character = (Character) roundManager.getGameObjectWithTurn().getCreature();
//            var array = generatePathsArrayList(character.getInventory().getDisposableItems());
//            mainPanelGame.getItemsItemPicker().uploadData(array);
//            mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
//                    indexOf(character.getInventory().getSelectedDisposableItem()));
//
//
//        }
//    }

    private ArrayList<String> generatePathsArrayList(List<? extends Item> items){
        var array = new ArrayList<String>();
        for (var item : items) {
            array.add(item.getItemPathPicture());
        }
        return array;
    }
}
