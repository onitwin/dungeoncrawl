import behaviors.IUse;
import characters.Fighter;
import gear.potions.HealingPotion;
import gear.potions.Potion;
import gear.weapons.Sword;
import gear.weapons.Weapon;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FighterTest {

    Fighter ajax;
    Fighter dave;
    Sword sword;
    Sword sword2;
    Potion potion;
    HealingPotion beetleJuice;

    @Before
        public void before() {
        sword = new Sword("Stabby", 40);
        sword2 = new Sword("Slashy", 10);
        potion = new HealingPotion("good for you" );
        ajax = new Fighter("Ajax", sword, 10, 20, 30);
        dave = new Fighter("Dave", sword2, 10, 20, 50);
        beetleJuice = new HealingPotion("Beetle Juice");
    }

    @Test
    public void canGetName(){
        assertEquals("Ajax", ajax.getName());
    }

    @Test
    public void canGetWeapon(){
        assertEquals(sword,ajax.getWeapon());
    }

    @Test
    public void canGetStates(){
        assertEquals(10, ajax.getAtk());
        assertEquals(20, ajax.getDef());
        assertEquals(30, ajax.getHp());
    }

    @Test
    public void canGetEquipment(){
        assertEquals(0,ajax.getEquipmentSize());
        ajax.addEquipment(sword);
        ajax.addEquipment(potion);
        assertEquals(2, ajax.getEquipmentSize());

    }

    @Test
    public void canSwapWeapon(){
        ajax.addEquipment(sword2);
        assertEquals("Stabby",ajax.getWeapon().getName());
        ajax.swopWeapon(sword2);
        assertEquals("Slashy",ajax.getWeapon().getName());
    }

    @Test
    public void canAttack(){
        assertEquals(50, dave.getHp());
        ajax.attack(dave);
        assertEquals(20,dave.getHp());
    }


    @Test
    public void canGetEquipmentList(){
        ajax.addEquipment(sword);
        ajax.addEquipment(sword2);
        ajax.addEquipment(potion);
        ArrayList<IUse> expected = new ArrayList<IUse>();
        expected.add(sword);
        expected.add(sword2);
        expected.add(potion);
        assertEquals(3,ajax.getEquipmentSize());
        assertEquals(expected,ajax.getEquipment());
    }

    @Test
    public void canRemoveSpecificItem(){
        ajax.addEquipment(sword);
        ajax.addEquipment(sword2);
        ajax.addEquipment(potion);
        ArrayList<IUse> expected = new ArrayList<IUse>();
        expected.add(sword);
        expected.add(sword2);
        ajax.removeEquipment(potion);
        assertEquals(expected, ajax.getEquipment());

    }



    @Test
    public void canUsePotion(){
        ajax.addEquipment(sword);
        ajax.addEquipment(sword2);
        ajax.addEquipment(beetleJuice);
        assertEquals(3, ajax.getEquipmentSize());
        assertEquals(30, ajax.getHp());
        System.out.println(String.format("First go %s" ,ajax.getHp()));
        ajax.usePotion(beetleJuice, ajax);
        System.out.println(String.format("Second go %s" ,ajax.getHp()));
        assertEquals(35,ajax.getHp());
        assertEquals(2, ajax.getEquipmentSize());
    }
//    @Test
//    public void canGetSpecificItem(){
//        ajax.addEquipment(sword);
//        ajax.addEquipment(sword2);
//        ajax.addEquipment(potion);
//        ArrayList<IUse> expected = new ArrayList<IUse>();
//        expected.add(sword);
//        expected.add(sword2);
//        expected.add(potion);
//        assertEquals("Stabby",ajax.specificItem());
//    }





}
