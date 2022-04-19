package br.pucpr.rpg;

import br.pucpr.rpg.items.Weapon;
import br.pucpr.rpg.system.DiceRoll;
import br.pucpr.rpg.system.Party;

public class Battle {

    public static void main(String[] args) {
        var heroes = new Party();

        var sword = new Weapon("Espada", new DiceRoll(1, 8));
        System.out.println("DANO DA ESPADA:" + sword.getDamage());
        var hero = new Char("Knight", 14, 5, 80);
        hero.setWeapon(sword);

        var spear = new Weapon("Lança", new DiceRoll(1, 6));
        System.out.println("DANO DA ESPADA:" + sword.getDamage());
        var sideKick = new Char("Spearman", 11, 5, 80);
        sideKick.setWeapon(spear);

        heroes.add(hero);
        heroes.add(sideKick);

        //var goblins = new Party(Char.createGoblins(5));
        //var encounter = new Party(heroes, goblins);
        //encounter;

        var enemy = Char.createEnemy();

        System.out.println("Nome do heroi: " + hero.getName());
        System.out.println("Nome do inimigo: " + enemy.getName());

        //BATALHA ATE A MORTE!!!!
        int turno = 1;

        //Enquanto o heroi e o inimigo estao vivos
        while (hero.isAlive() && enemy.isAlive()) {
            System.out.println("TURNO " + turno);
            hero.attack(enemy);
            enemy.attack(hero);
            turno++;
            System.out.println();
        }

        var winner = hero.getLife() > 0 ? hero : enemy;
        System.out.println(winner.getName() + " venceu!");
    }



}
