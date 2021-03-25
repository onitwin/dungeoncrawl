package logic;

import behaviors.IUse;
import characters.Monster;
import characters.Player;
import dungeon.Room;
import gear.potions.Potion;

import java.util.ArrayList;
import java.util.Scanner;

public class AttackOptions {

    private Player player;
//    private ArrayList<Monster> monsters;
    private Room room;

//    public AttackOptions(Player player, ArrayList monsters){
//        this.player = player;
//        this.monsters = monsters;
//
//    }
    public AttackOptions(Player player, Room room){
        this.player = player;
        this.room = room;

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
//
//    public ArrayList<Monster> getMonsters() {
//        return monsters;
//    }

//    public void setMonsters(ArrayList<Monster> monsters) {
//        this.monsters = monsters;
//    }



    public void getAttackOptions(){
        while( this.room.getMonstersSize() > 0) {
            System.out.println(" ");
            System.out.println("You are in combat!");
            System.out.println(" ");
            System.out.println("CHOOSE COMBAT ACTION... ");
            System.out.println(" ");
            System.out.println("1: Attack an enemy.");
            System.out.println("2: Swap Weapon.");
            System.out.println("3: Use Potion.");
            System.out.println("4: Check Status.");

            System.out.println(" ");


            Scanner choice = new Scanner(System.in);
            int selection = choice.nextInt();


            switch(selection){
                case 1:
                    combat();
                    System.out.println("You attack!");
                    break;
                case 2:
                    this.player.changeWeapon();
                    System.out.println("You swap weapons!");
                    break;
                case 3:
                    this.player.usePotion();
                    System.out.println("You use a potion!");
                    break;

                case 4:
                    this.player.getStatus();
                    System.out.println(" ");
                    break;

//                case 5:
//                    System.out.println("Activate God Mode");
//                    this.player.setHp(1000);
//                    this.player.setAtk(1000);


            }

        }




    }

    public void combat(){
        System.out.println(String.format("You are fighting %s creature(s)",room.getMonstersSize()));
        ArrayList<Monster>monsters=this.room.getMonsters();

        for ( Monster monster: monsters) {
            System.out.println(String.format("One opponent is a %s ",monster.getName()));
        }

        Scanner monsterChoice=new Scanner(System.in);
        if (this.room.getMonstersSize()>1){
            System.out.println("Which monster would you like to attack?");
        }else{
            System.out.println("There is only one opponent to attack?");
        }

        for(int i=0;i<room.getMonstersSize();i++){
            String creatureName=monsters.get(i).getName();
            System.out.println(String.format("%s: Attack %s", i + 1, creatureName));
        }
        int choice = monsterChoice.nextInt()-1;
        this.player.attack(monsters.get(choice));

    };



}

