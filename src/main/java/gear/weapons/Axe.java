package gear.weapons;

public class Axe  extends Weapon{

    public Axe(String name,int damage){
        super(name,damage);
        this.damageType=DamageType.SLASH;
    }



        public String description(){
            return "You swapped to the mighty battle axe..";
        }

}
