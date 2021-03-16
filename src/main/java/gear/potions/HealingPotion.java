package gear.potions;

import behaviors.IUse;
import characters.Player;

public class HealingPotion extends Potion {

    public HealingPotion(String name) {
        super(name);
    }

    public void effect(Player player) {
        player.setHp(player.getHp() + 5);
    }

    public String description(){
        return "You drink the healing portion you feel your wounds knit back together..";
    }
}