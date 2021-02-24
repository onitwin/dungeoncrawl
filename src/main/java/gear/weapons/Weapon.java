package gear.weapons;

import behaviors.IUse;

public abstract class Weapon implements IUse {
    private String name;
    private int damage;
    protected DamageType damageType;

    public Weapon(String name,int damage){
        this.name=name;
        this.damage=damage;
        this.damageType=DamageType.BLUDGEON;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public void effect(){
        this.damage=this.damage+1;
    }


}
