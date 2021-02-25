package gear.weapons;

import characters.Player;

public class Mace extends Weapon {

    public Mace(String name, int damage){
        super(name,damage);
        this.damageType=DamageType.BLUDGEON;
    }

    public void effect(Player player){
        player.setHp(player.getHp()-4);
    }
}
