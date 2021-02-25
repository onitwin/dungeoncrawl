package gear.potions;

import behaviors.IUse;
import characters.Player;

public class HealingPotion extends Potion {

    public HealingPotion(String name){
        super(name);
    }

    public void effect(Player player){
        player.setHp(player.getHp()+5);
    }

    @Override
    public void nonsense() {
       System.out.println("NOOOOOOOO, this is nonsense!!");
    }
}
