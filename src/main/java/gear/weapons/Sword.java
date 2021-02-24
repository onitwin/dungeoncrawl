package gear.weapons;

public class Sword extends Weapon {

    public Sword(String name, int damage){
        super(name,damage);
        this.damageType=DamageType.SLASH;
    }

    public void effect(){
        if(this.damageType==DamageType.SLASH){
            this.damageType=DamageType.STAB;
        }else{
            this.damageType=DamageType.SLASH;
        }
    }
}
