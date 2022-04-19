package br.pucpr.rpg.system;

import br.pucpr.rpg.Char;

public class Initiative implements Comparable<Initiative>{
    private Char character;
    private  int initiative;

    public Initiative(Char character, int initiative) {
        this.character = character;
        this.initiative = initiative;
    }

    public Char getCharacter() {
        return character;
    }

    public int getInitiative() {
        return initiative;
    }

    @Override
    public int compareTo(Initiative o) {
        if (initiative < o.initiative)
            return 1;
        if(initiative > o.initiative)
            return -1;
        return 0;
    }
}
