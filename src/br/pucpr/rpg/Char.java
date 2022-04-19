package br.pucpr.rpg;

import br.pucpr.rpg.items.Weapon;
import br.pucpr.rpg.items.Potion;
import br.pucpr.rpg.system.DiceRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Char { //character
    private static final Random RANDOM = new Random();

    private String name;
    private int skill;
    private int defense;
    private int maxLife;
    private int life;

    private Weapon weapon;
    private Potion potion;

    public Char(String name, int skill, int defense, int life, Weapon weapon) {

        if (skill<=0) {
            throw new IllegalArgumentException("A skill deve ser maior que zero.");
        }

        if (defense<0) {
            throw new IllegalArgumentException("A defesa deve ser maior que zero.");
        }

        if (life <0) {
            throw new IllegalArgumentException("A vida deve ser maior que zero.");
        }
        if (weapon == null){
            weapon = Weapon.BARE_HANDS;
        }

        this.name = name== null ? "" : name;
        this.skill = skill;
        this.defense = defense;
        this.life = life;
        this.maxLife = life;
        this.weapon = weapon;

    }

    public Char (String name, int skill, int defense, int life){
        this(name, skill, defense, life, Weapon.BARE_HANDS);
    }

    public static Char createEnemy() {
        String names[] = {"Jorge", "Neto", "Splitz", "Giblles", "Toink"};
        String surnames[] = {"Potter", "the weak", "one eyed", "chief", "cook"};

        String enemyName = names[RANDOM.nextInt(names.length)] + " "
                + surnames[RANDOM.nextInt(surnames.length)];

        int skill = 8 + RANDOM.nextInt(9);
        int defense = 1 + RANDOM.nextInt(4);
        int life = 10 + RANDOM.nextInt(31);
        var enemy = new Char(enemyName, skill, defense, life);
        enemy.setWeapon(new Weapon("Punhal", new DiceRoll(2, 4, -1)));
        return enemy;
    }



    public void attack(Char enemy) {
        if (!isAlive()) {
            return;
        }

        System.out.printf("%s ataca %s! ", name, enemy.name);
        int dice1 = RANDOM.nextInt(6) + 1;
        int dice2 = RANDOM.nextInt(6) + 1;
        int dice3 = RANDOM.nextInt(6) + 1;

        int roll = dice1 + dice2 + dice3;
        int target = skill - enemy.defense;
        if (roll <= target) {
            System.out.println("ACERTOU COM "+ weapon+ "!");
            System.out.println(weapon.getName().toUpperCase() + "!");
            int damage = weapon.wound();
            enemy.takeDamage(damage);

        } else {
            System.out.println("ERRRRRROU !");
        }
    }
    public void takeDamage(int damage) {
        life = life - damage;
        if (life < 0) {
            life = 0;
        }
        System.out.printf("%s levou %d de dano. Life: %s%n",
                name, damage, life);
    }

    /*public static List<Char> createGoblins (int number){
        var goblins = new ArrayList<>();
        return;
    }*/


    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public int getDefense() {
        return defense;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon ==null ? Weapon.BARE_HANDS : weapon;
    }


}
