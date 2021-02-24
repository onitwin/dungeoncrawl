package gear.potions;

import behaviors.IUse;

public class Potion implements IUse {
    private String name;
    private boolean used;

    public Potion(String name){
        this.name=name;
        this.used=false;

    }


    public void effect(){
        this.used=true;
    }

}
