package gear.weapons;

import characters.Player;

public class Sword extends Weapon {

    public Sword(String name, int damage){
        super(name,damage);
        this.damageType=DamageType.SLASH;
    }

    public void effect(Player player){
        player.setHp(player.getHp()-3);
    }
}
