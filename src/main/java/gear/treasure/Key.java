package gear.treasure;

public class Key extends Loot {

    public Key(String name, int value){
        super(name, value);
    }

    public String description(){
        return "The key fits in the lock.. your turn it...";
    }


}
