package br.pucpr.rpg.system;

import java.util.ArrayList;
import java.util.Collections;

public class Encounter {
    private Party group1;
    private Party group2;

    public Encounter(Party group1, Party group2) {
        this.group1 = group1;
        this.group2 = group2;
    }

    public boolean ended(){
        return group1.allDead() || group2.allDead();
    }

    public void processTurn() {
        var initiatives = new ArrayList<Initiative>();
        initiatives.addAll(group1.rollInitiatives());
        initiatives.addAll(group2.rollInitiatives());
        Collections.sort(initiatives);

        /*for(var initiatives : initiatives) {
            var attacker = initiatives.getCharacter();
            var targets = group1.contains(attacker) ?
                    group2 : group1;
            var target = targets.random();
            if (target == null) break;
            attacker.takeTurn(target);
        }*/

    }

    public void process() {
        //BATALHA ATE A MORTE!!!!
        int turn = 1;

        //Enquanto o heroi e o inimigo estao vivos
        while (!ended()) {
            System.out.println("TURNO " + turn);
            processTurn();
            turn++;
            System.out.println();
        }
    }


}
