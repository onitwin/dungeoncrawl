import characters.Fighter;
import characters.Monster;
import characters.Player;
import characters.Skeleton;
import dungeon.Room;
import gear.potions.HealingPotion;
import gear.treasure.Coin;
import gear.treasure.Key;
import gear.weapons.Axe;
import gear.weapons.Sword;
import logic.PlayerOptions;

import java.util.Scanner;

public class Runner {


    public static void main(String [] args){
        Room kitchen =new Room("Kitchen","A small and dirty kitchen, covered in dust and cobwebs.");
        Room bedroom= new Room("Master Bedroom","A well kept and ostentatious room focused around a four poster bed.");
        Room dungeon=new Room ("Dungeon", "Blood covered tools, shackels and flagstones draw the eye.");
        Sword shinysword=new Sword("Greatsword",5);
        Axe bloodyAxe=new Axe("Bloody Axe",10);
        HealingPotion healingPotion= new HealingPotion("Red potion");
        HealingPotion healingGreater= new HealingPotion("Blue potion");
        HealingPotion healingLesser= new HealingPotion("Green potion");


        Skeleton skully=new Skeleton("Skully",shinysword,5,5,30);
        Skeleton bonesy=new Skeleton("bonesy",shinysword,5,5,30);
        Key rustykey=new Key("Rusty Key",0);




        kitchen.addMonster(skully);
        kitchen.addLoot(rustykey);
        kitchen.addExits("North",dungeon);
        kitchen.addExits("South",bedroom);
        dungeon.addExits("South",kitchen);
        bedroom.addExits("North",kitchen);
        dungeon.addMonster(bonesy);
        dungeon.addLoot(rustykey);


        System.out.println("Welcome to Castle Code");


        Scanner gamer=new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name=gamer.nextLine();
        System.out.println(String.format("Welcome %s",name));

        Fighter player=new Fighter(name,shinysword,10,10,30);
        player.addEquipment(bloodyAxe);
        player.addEquipment(healingGreater);
        player.addEquipment(healingLesser);
        player.addEquipment(healingPotion);


        PlayerOptions options=new PlayerOptions(player,kitchen);
        System.out.println("Forced against your will to enter the abandoned castle, you steel yourself and approach the first door. The doorway behind you disappears...");
        kitchen.addPlayer(player);
        kitchen.getExitString();
        while(player.getHp()>0){
            options.presentChoices();
        }



    }
}


