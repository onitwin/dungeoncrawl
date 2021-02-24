package gear.potions;

import characters.Player;

public class HealingPotion extends Potion{

    public HealingPotion(String name){
        super(name);
    }

    public void effect(Player player){
        player.setHp(player.getHp()+5);
    }
}
