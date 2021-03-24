package logic;

import characters.Monster;
import characters.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class AttackOptions {

    private Player player;
    private ArrayList<Monster> monsters;

    public AttackOptions(Player player, ArrayList monsters){
        this.player = player;
        this.monsters = monsters;

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }



    public void getAttackOptions(){
        while( monsters.size() > 0) {
            System.out.println(" ");
            System.out.println("You are in combat!");
            System.out.println(" ");
            System.out.println("CHOOSE COMBAT ACTION... ");
            System.out.println(" ");
            System.out.println("1: Attack an enemy.");
            System.out.println("2: Swap Weapon.");
            System.out.println("3: Use Potion.");
            System.out.println(" ");

            Scanner choice = new Scanner(System.in);
            int selection = choice.nextInt();


            switch(selection){
                case 1:
                    System.out.println("You attack!");
                    break;
                case 2:
                    System.out.println("You swap weapons!");
                    break;
                case 3:
                    System.out.println("You use a potion!");


            }

        }







    }


}
