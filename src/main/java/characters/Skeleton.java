package characters;

import behaviors.IUse;
import gear.weapons.Weapon;

public class Skeleton extends Monster{

    public Skeleton(String name, IUse weapon, int atk, int def, int hp){
        super(name,weapon,atk,def,hp);
    }
}
