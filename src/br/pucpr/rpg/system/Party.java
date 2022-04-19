package br.pucpr.rpg.system;

import br.pucpr.rpg.Char;

import java.util.*;

public class Party {
    private static final Random RND = new Random();
    private List<Char> members;

    public Party(){
        members = new ArrayList<>();
    }

    public Party(List<Char> members) {
        this.members = new ArrayList<>(members);
    }

    public void add(Char member) {
        members.add(member);
    }

    public List<Char> alive() {
        var alive = new ArrayList<Char>();
        for (var member : members) {
            if (member.isAlive()) {
                alive.add(member);
            }
        }
        return alive;
    }

    public Char random() {
        var aliveMembers = alive();
        return aliveMembers.size() == 0 ?
                null :
                aliveMembers.get(RND.nextInt(aliveMembers.size()));
    }

    public boolean allDead() {
        return alive().size() ==0;
    }

    public boolean contains(Char c) {
        return members.contains(c);
    }

    public List<Initiative> rollInitiatives() {
        var initiatives  = new ArrayList<Initiative>();
        var d20 = new DiceRoll(1, 20);

        for (var member : alive()) {
            initiatives.add(new Initiative((member), d20.roll()));
        }
        return initiatives;
    }

    public List<Char> getMembers() {
        return Collections.unmodifiableList(members);
    }

}
