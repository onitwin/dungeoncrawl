import characters.Fighter;
import characters.Monster;
import characters.Skeleton;
import dungeon.Room;
import gear.potions.HealingPotion;
import gear.treasure.Key;
import gear.weapons.Sword;

import java.util.Scanner;

public class Runner {


    public static void main(String [] args){
        Room kitchen =new Room("Kitchen","A small and dirty kitchen, coverd in dust and cobwebs");
        Room bedroom= new Room("Master Bedroom","A well kept and ostentatious room focused around a four poster bed");
        Room dungeon=new Room ("Dungeon", "Blood covered tools, shackels and flagstones draw the eye");
        Sword shinysword=new Sword("Greatsword",5);
        HealingPotion healingPotion= new HealingPotion("Blue potion");
        Skeleton skully=new Skeleton("Skully",shinysword,5,5,30);
        Skeleton bonesy=new Skeleton("bonesy",shinysword,5,5,30);
        Key rustykey=new Key("Rusty Key",0);


        System.out.println("Welcome to Castle Code");


        Scanner gamer=new Scanner(System.in);
        System.out.println("Please enter your name");
        String name=gamer.nextLine();
        System.out.println(String.format("Welcome %s",name));

        Fighter player=new Fighter(name,shinysword,10,10,30);
        System.out.println("Forced against your will to enter the abandoned castle, you steel yourself and approach the first door");

    }
}


