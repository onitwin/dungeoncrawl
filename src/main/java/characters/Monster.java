package characters;

import gear.weapons.Weapon;

public abstract class Monster extends Player{

    public Monster(String name, Weapon weapon, int atk, int def, int hp){
        super(name,weapon,atk,def,hp);
    }
}
