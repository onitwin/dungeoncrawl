package gear.potions;

import behaviors.IUse;
import characters.Player;

public class Potion implements IUse {
    private String name;

    public Potion(String name){
        this.name=name;

    }


    public void effect(){
        System.out.println(String.format("%s has been used", this.name ));

    }




}
