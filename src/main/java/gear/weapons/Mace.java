package gear.weapons;

public class Mace extends Weapon {

    public Mace(String name, int damage){
        super(name,damage);
        this.damageType=DamageType.BLUDGEON;
    }
}
