package gear.potions;

import behaviors.IUse;
import characters.Player;

public class HealingPotion extends Potion {

    public HealingPotion(String name){
        super(name);
    }

    public void effect(){
        player.setHp(player.getHp()+5);
    }


}
