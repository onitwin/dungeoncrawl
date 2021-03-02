package gear.potions;

import behaviors.IUse;
import characters.Player;

public abstract class Potion implements IUse {
    private String name;

    public Potion(String name){
        this.name=name;

    }

    public String getName(){
        return this.name;
    }



    public void effect(Player player){
        System.out.println(String.format("%s has been used", this.name ));

    }





}
