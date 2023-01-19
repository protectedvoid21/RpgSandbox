package gui.actionListener.creatureMenagment;

import game.creature.Monster;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MonsterDeleteListener implements ActionListener {

    ArrayList<Monster> mockMonster;
    Monster dependMonster;

    public MonsterDeleteListener( ArrayList<Monster> mockMonster, Monster dependMonster){
        this.mockMonster = mockMonster;
        this.dependMonster = dependMonster;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        mockMonster.remove(dependMonster);
    }
}

