package gui.actionListener.basicActionsListener;

import controllers.audio.CustomAudioManager;
import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.PathsArrayListGenerator;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.ACTIONS_TO_DO;

public class UseItemOnYourselfListener implements ActionListener {
private ListenerBaseData listenerBaseData;
//    RoundManager roundManager;
//    MainPanelGame mainPanelGame;
//    private CustomAudioManager audio;
    public UseItemOnYourselfListener(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
//        this.audio = audio;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();

        if(you instanceof Character){
            ((Character) you).getInventory().getSelectedDisposableItem().use(you);
        }


        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        if (you instanceof Character) {
            var character = (Character) you;
//            var array = new ArrayList<String>();
//            for (var item : character.getInventory().getDisposableItems()) {
//                if(item.isValid())
//                array.add(item.getItemPathPicture());
//            }
            var array = PathsArrayListGenerator.generatePathsArrayList(character.getInventory().getDisposableItems());
            listenerBaseData.mainPanelGame.getItemsItemPicker().uploadData(array);
            listenerBaseData.mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));

            listenerBaseData.mainPanelGame.getItemsItemPicker().addButtonLIstener(new UseListener(listenerBaseData));


        }

    }
}
