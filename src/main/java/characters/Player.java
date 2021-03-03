package characters;

import behaviors.IAttack;
import behaviors.IUse;
import gear.potions.HealingPotion;
import gear.potions.Potion;
import gear.weapons.Sword;
import gear.weapons.Weapon;

import java.util.ArrayList;

public abstract class Player implements IAttack {
    private String name;
    protected Weapon weapon;
    private ArrayList<IUse> equipment;
    private int atk;
    private int def;
    private int hp;

    public Player(String name,Weapon weapon,int atk,int def,int hp){
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<IUse> getEquipment() {
        return equipment;
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

    public void swopWeapon(Weapon newWeapon){

        this.weapon=newWeapon;
    }

    public void attack(Player player){
        int totalDamage = this.atk + this.weapon.getDamage() - player.getDef();
        player.setHp(player.getHp() - totalDamage) ;
    }


    public void usePotion( IUse item, Player player){
        System.out.println(String.format("%s items in the bag",this.getEquipmentSize()));
        IUse returnedItem = player.removeEquipment(item);
        System.out.println(String.format("%s items in the bag",this.getEquipmentSize()));
        returnedItem.effect(player);
        System.out.println(returnedItem instanceof IUse);

    }

//     ((Potion)returnedItem).nonsense(); casting example






}
