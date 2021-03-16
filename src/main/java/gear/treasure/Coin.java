package gear.treasure;

public class Coin extends Loot {


    public Coin(String name, int value){
        super(name, value);
    }

    public String description(){
        return "its dull and rusted.. probably worthless..";
    }


}
