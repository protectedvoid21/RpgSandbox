package gui.actionListener.creatureMenagment;

import game.creature.Monster;
import game.filehandle.EntityManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MonsterDeleteListener implements ActionListener {

    EntityManager entityManager;
    Monster dependMonster;

    public MonsterDeleteListener( EntityManager entityManager, Monster dependMonster){
        this.entityManager = entityManager;
        this.dependMonster = dependMonster;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        entityManager.removeMonster(dependMonster);
    }
}

