package logic;

import behaviors.IUse;
import characters.Player;
import dungeon.Room;

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
        System.out.println("4:Check equipment");
        System.out.println("5:Change weapon");
        System.out.println("6:Use Item");
        System.out.println(" ");

        Scanner choice=new Scanner(System.in);
        int door= choice.nextInt();
        switch(door){
            case 1:
                System.out.println("You attack");
                break;
            case 2:
                System.out.println("You pick up the loot");
                for(IUse loot:this.room.getAllLoot()){
                    this.room.passLoot(loot);
                }
                break;
            case 3:
                System.out.println("You check the exits");
                break;
            case 4:
                this.player.getGear();
                System.out.println(" ");
                break;
            case 5:
                System.out.println("You swop weapons");
                break;
            case 6:
                System.out.println("You use the item");
                break;
        }

    }

    public void chooseExit(Room room){
        Scanner choice=new Scanner(System.in);
        String door= choice.nextLine();
    }
}
