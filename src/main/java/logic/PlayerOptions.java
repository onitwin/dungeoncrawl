package logic;

import behaviors.IUse;
import characters.Player;
import dungeon.Room;
import gear.potions.Potion;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerOptions {
    Room room;
    Player player;





    public PlayerOptions(Player player, Room room){
        this.room=room;
        this.player=player;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void presentChoices(){
        System.out.println(" ");
        System.out.println("Choose action:");
        if(this.room.getMonstersSize()>0){
            System.out.println("1:Attack");
        }
        if (this.room.getLootSize()>0){
            System.out.println("2:Pick up loot");
        }
        if(this.room.getMonstersSize()<3){
            System.out.println("3:Choose exit");
        }
        System.out.println("4:Check status");
        System.out.println("5:Change weapon");
        System.out.println("6:Use Item");
        System.out.println("7:Examine Room ");
        System.out.println(" ");

        Scanner choice=new Scanner(System.in);
        int door= choice.nextInt();
        switch(door){
            case 1:
                System.out.println("You attack");
                break;
            case 2:
                System.out.println("You pick up the loot");
                collectLoot();

                break;
            case 3:
                System.out.println("You check the exits");
                System.out.println(" ");
                break;
            case 4:
                this.player.getStatus();
                System.out.println(" ");
                break;
            case 5:
                System.out.println("You swap weapons");
                break;
            case 6:
                usePotion();
                break;
            case 7:
                System.out.println(this.room.getDescription());
                System.out.println(" ");


        }

    }

    public void chooseExit(Room room){
        Scanner choice=new Scanner(System.in);
        String door= choice.nextLine();
    }

    public void collectLoot() {
        int lootSize = this.room.getLootSize();
        int i = 0;
        while (i < lootSize) {
            this.room.passLoot(this.room.individualItemOfLoot());
            i++;
        }
    }

    public void usePotion() {
        ArrayList<IUse> ownedPotions;

        ownedPotions = new ArrayList<IUse>();

        for (IUse item : this.player.getEquipment()) {
            if (item instanceof Potion) {
                ownedPotions.add(item);
            }
        }
        for (IUse potion : ownedPotions) {
            System.out.println(String.format("You have a %s", potion.getName()));

        }
        System.out.println(" ");
        Scanner potionChoice = new Scanner(System.in);
        System.out.println("Which potion would you like to use? ");
        System.out.println(" ");

        int arrayLength = ownedPotions.size();
        for (int i = 0; i < arrayLength; i++) {

            String singleItem = ownedPotions.get(i).getName();
            System.out.println(String.format("%s: %s ", i + 1, singleItem));

        }

        int choice = potionChoice.nextInt();
        choice = choice -1;
        IUse selectedPotion = ownedPotions.get(choice);
         player.usePotion(selectedPotion, this.player);
         System.out.println(String.format("%s has used %s", this.player.getName(), selectedPotion.getName()));






        //Loop through owedPotions with users choice cast object back to type Potion and call this.player.usePotion()
        // int i =1
        //for(IUse item:equipment){
        //if (item.getClass() == potion){
        //   System.out.println(String.format("%s : item.getName")
        //i++}
        //int selection=


    }
}
