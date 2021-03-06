package characters;

import behaviors.IAttack;
import behaviors.IUse;
import gear.potions.HealingPotion;
import gear.potions.Potion;
import gear.weapons.Axe;
import gear.weapons.Sword;
import gear.weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Player implements IAttack {
    private String name;
    protected IUse weapon;
    private ArrayList<IUse> equipment;
    private int atk;
    private int def;
    private int hp;

    public Player(String name,IUse weapon,int atk,int def,int hp){
        this.name=name;
        this.weapon=weapon;
        this.atk=atk;
        this.def=def;
        this.hp=hp;
        this.equipment=new ArrayList<IUse>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IUse getWeapon() {
        return weapon;
    }

    public void setWeapon(IUse weapon) {
        this.weapon = weapon;
    }

    public ArrayList<IUse> getEquipment() {
        return equipment;
    }

    public void getGear(){
        for (IUse gear:this.equipment){
            System.out.println(String.format("You have a %s", gear.getName()));
        }
    }

    public void setEquipment(ArrayList<IUse> equipment) {
        this.equipment = equipment;
    }

    public void addEquipment(IUse item){
         equipment.add(item);

    }

    public int getEquipmentSize(){
        return this.equipment.size();
    }

    public IUse removeEquipment(IUse item){
        IUse returnEquip = this.equipment.remove(this.equipment.indexOf(item));
            return returnEquip;
    }




    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void swopWeapon(IUse newWeapon){
        equipment.add(this.weapon);
        this.weapon=removeEquipment(newWeapon);
    }

    public void attack(Player player){
        int totalDamage = this.atk + ((Weapon)this.weapon).getDamage() - player.getDef();
        player.setHp(player.getHp() - totalDamage) ;
    }


    public void usePotion( IUse item, Player player){
        IUse returnedItem = player.removeEquipment(item);
        returnedItem.effect(player);
    }

    public void getStatus(){
        System.out.println(" ");
        System.out.println(String.format("| Health: %s | Attack: %s | Defence: %s |", this.hp, this.atk, this.def));
        System.out.println(String.format("Current Weapon: %s", this.weapon.getName()));
        getGear();

    }

    public void changeWeapon(){
        ArrayList<IUse> ownedWeapons;

        ownedWeapons = new ArrayList<IUse>();

        for(IUse item : getEquipment()){
            if(item instanceof Weapon){
                ownedWeapons.add(item);
            }
        }
        for(IUse item : ownedWeapons){
            System.out.println(String.format("You have a %s", item.getName()));
        }
        System.out.println(" ");

        Scanner weaponChoice = new Scanner(System.in);
        System.out.println("Which weapon would you like to use? ");
        System.out.println(" ");

        int arrayLength = ownedWeapons.size();
        for (int i = 0; i < arrayLength; i++) {

            String singleItem = ownedWeapons.get(i).getName();
            System.out.println(String.format("%s: %s ", i + 1, singleItem));

        }

        int choice = weaponChoice.nextInt();
        choice = choice -1;
        swopWeapon(ownedWeapons.get(choice));
        System.out.println(String.format("%s has swapped to %s", getName(), getWeapon().getName()));




    }

    public void usePotion() {
        ArrayList<IUse> ownedPotions;

        ownedPotions = new ArrayList<IUse>();

        for (IUse item : getEquipment()) {
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

        if(choice < 1 || choice > ownedPotions.size()) {
            System.out.println("ENTER VALID NUMBER!");
            System.out.println(" ");

            usePotion();

        }

        choice = choice - 1;
        IUse selectedPotion = ownedPotions.get(choice);
        usePotion(selectedPotion, this);
        System.out.println(String.format("%s has used %s", getName(), selectedPotion.getName()));
        Potion newPotion = (Potion) selectedPotion;
        System.out.println(newPotion.description());
//     ((Potion)returnedItem).nonsense(); casting example


    }



}
