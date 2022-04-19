package br.pucpr.rpg.items;

import br.pucpr.rpg.system.DiceRoll;

import java.util.Random;

public class Weapon {
    public static final Weapon BARE_HANDS = new Weapon("MÃOS LIMPAS", new DiceRoll(0,0, 1));

    private static final Random RND = new Random();
    private String name;
    private DiceRoll damage;

    public Weapon(String name, DiceRoll damage) {
        this.name = name;
        if (damage == null) {
            throw new IllegalArgumentException("Damage cannot be null!");
        }
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public DiceRoll getDamage() {
        return damage;
    }

    public int wound() {
        return damage.roll();
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, damage);
    }
}
