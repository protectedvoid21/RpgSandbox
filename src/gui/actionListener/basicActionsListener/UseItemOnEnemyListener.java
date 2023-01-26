package gui.actionListener.basicActionsListener;

import controllers.audio.CustomAudioManager;
import game.board.RoundManager;
import game.creature.Character;
import game.creature.Creature;
import game.generals.Vector2;
import gui.actionListener.ListenerBaseData;
import gui.actionListener.PathsArrayListGenerator;
import gui.actionListener.turnOffButtons;
import gui.views.gamePanel.MainPanelGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static game.interfaceWarhammer.StruggleAtributeEnum.*;

public class UseItemOnEnemyListener implements ActionListener {

    private ListenerBaseData listenerBaseData;
//    RoundManager roundManager;
//    MainPanelGame mainPanelGame;
//    private CustomAudioManager audioManager;

    public UseItemOnEnemyListener(ListenerBaseData listenerBaseData) {
//        this.roundManager = roundManager;
//        this.mainPanelGame = mainPanelGame;
//        this.audioManager= audioManager;
        this.listenerBaseData = listenerBaseData;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Vector2 point = listenerBaseData.mainPanelGame.getGamePanel().getCurrentClickedIndexes();
        Creature you = listenerBaseData.roundManager.getGameObjectWithTurn().getCreature();

        if (you instanceof Character) {
            ((Character) you).getInventory().getSelectedDisposableItem().use(listenerBaseData.roundManager.getBoard().getPlace(point).getGameObject().getCreature());
        }

        you.getStruggleStatistics().getAttribute(ACTIONS_TO_DO).decreaseValue(1);
        listenerBaseData.mainPanelGame.getGamePanel().changeActiveOptionsPanel();
        if (you instanceof Character) {
            var character = (Character) you;
//            var array = new ArrayList<String>();
//            for (var item : character.getInventory().getDisposableItems()) {
//                if (item.isValid())
//                    array.add(item.getItemPathPicture());
//            }
            var array = PathsArrayListGenerator.generatePathsArrayList(character.getInventory().getDisposableItems());
            listenerBaseData.mainPanelGame.getItemsItemPicker().uploadData(array);
            listenerBaseData.mainPanelGame.getItemsItemPicker().setCurrentIndex(character.getInventory().getDisposableItems().
                    indexOf(character.getInventory().getSelectedDisposableItem()));
            listenerBaseData.mainPanelGame.getItemsItemPicker().addButtonLIstener(new UseListener(listenerBaseData));

        }

    }

}
