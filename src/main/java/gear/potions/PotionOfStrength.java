package gear.potions;

import characters.Player;

public class PotionOfStrength extends Potion{

    public PotionOfStrength(String name){
        super(name);

    }

    public void effect(Player player){
        player.setAtk(player.getAtk()+5);
    }
    public String description(){
        return "You drink the Potion of Strength and your muscles bulge..";
    }
}
