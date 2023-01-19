package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.creature.PlayerCharacter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PCDeleteListener implements ActionListener {

    ArrayList<PlayerCharacter> mockPC;
    PlayerCharacter dependPC;

    public PCDeleteListener( ArrayList<PlayerCharacter> mockPC, PlayerCharacter dependPC){
        this.mockPC = mockPC;
        this.dependPC = dependPC;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mockPC.remove(dependPC);
    }
}
