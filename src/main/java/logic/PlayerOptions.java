package logic;

import behaviors.IUse;
import characters.Player;
import dungeon.Room;
import gear.potions.HealingPotion;
import gear.potions.Potion;
import gear.weapons.Weapon;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerOptions {
    private Room room;
    private  Player player;
    private AttackOptions atkOptions;





    public PlayerOptions(Player player, Room room){
        this.room=room;
        this.player=player;
//        this.atkOptions = new AttackOptions(player, room.getMonsters());
        this.atkOptions = new AttackOptions(player,room);
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
        System.out.println("CHOOSE ACTION:");
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
                this.atkOptions.getAttackOptions();
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
                this.player.changeWeapon();
                System.out.println("You swap weapons");
                break;
            case 6:
                this.player.usePotion();
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




        //Loop through owedPotions with users choice cast object back to type Potion and call this.player.usePotion()
        // int i =1
        //for(IUse item:equipment){
        //if (item.getClass() == potion){
        //   System.out.println(String.format("%s : item.getName")
        //i++}
        //int selection=

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//attack option>>>>>1:attack a monster>>>>which monster>>>>resolve attack>>>check if monster dead>>>if not>>>monsters hit back>>>>
//attack opion>>>>>2:swop weapons>>>>>>>>call method to swop weapons>>>>monsters attack you
//attack option>>>>3:take potion>>>>>>resolve potion>>>>monsters attack you
