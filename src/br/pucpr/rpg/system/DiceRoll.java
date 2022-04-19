package br.pucpr.rpg.system;

import java.util.Random;

public class DiceRoll {

    private int amount;
    private int faces;
    private int modifier;
    private static final Random RND = new Random();

    public DiceRoll(int amount, int faces, int modifier) {
        this.amount = amount;
        this.faces = faces;
        this.modifier = modifier;
    }

    public DiceRoll(int amount) {
        this(amount, 6);
    }

    public DiceRoll(int amount, int faces) {
        this(amount, faces, 0);
    }

    public int roll(){
        int total = 0;
        for (int i = 0; i < amount; i++){
            total += RND.nextInt(faces) + 1;
        }
        total+= modifier;
        return total > 0 ? total : 0;
    }

    @Override
    public String toString(){
        var sb = new StringBuilder();
        sb.append(amount).append("D").append(faces);
        if (modifier ==0) return sb.toString();

        if (modifier > 0) {
            sb.append("+");
        }
        sb.append(modifier);
        return sb.toString();
    }
}
