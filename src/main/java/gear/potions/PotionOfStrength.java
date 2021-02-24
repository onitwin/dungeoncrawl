package gear.potions;

import characters.Player;

public class PotionOfStrength extends Potion{

    public PotionOfStrength(String name){
        super(name);

    }

    public void effect(Player player){
        player.setAtk(player.getAtk()+5);
    }
}
