package gear.treasure;

import behaviors.IUse;
import characters.Player;

public abstract class Loot implements IUse {

    private String name;
    private int value;






    public Loot(String name,int value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void effect(Player player){

    }
}
