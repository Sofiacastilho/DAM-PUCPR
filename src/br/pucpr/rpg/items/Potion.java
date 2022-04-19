package br.pucpr.rpg.items;

import br.pucpr.rpg.Char;
import br.pucpr.rpg.system.DiceRoll;

public class Potion {

    private int hpPotion = 10;
    private boolean potion;
    private DiceRoll diceRoll;


    public boolean existPotion(){
        return potion;
    }

    public void drinkPotion(Char character){
        if (hpPotion > 0 ) {
            var d6 = new DiceRoll(1, 6);
            var sip = d6.roll(); //gole

            if (sip > hpPotion) { //se gole maior q hppotion
                setHpPotion(0); //seta a potion pra 0

            }else{
                setHpPotion(hpPotion - sip); //seta a potion pro novo valor
            }

            int lifeAfterPotion = character.getLife() + sip; //vida dps da potion
            character.setLife(lifeAfterPotion); //seta vida dps da potion

            System.out.println("Bebeu poção, vida atual de: "+ character.getLife());
        }
        else {  //(hpPotion <= 0)
            setPotion(false);
        }
    }

    public Potion(int hpPotion) {
        this.hpPotion = hpPotion;
    }

    public int getHpPotion() {
        return hpPotion;
    }

    public void setHpPotion(int hpPotion) {
        this.hpPotion = hpPotion;
    }

    public boolean isPotion() {
        return potion;
    }

    public void setPotion(boolean potion) {
        this.potion = potion;
    }
}