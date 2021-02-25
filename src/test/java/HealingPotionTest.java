import characters.Fighter;
import gear.potions.HealingPotion;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealingPotionTest {
    HealingPotion healing;
    Fighter ajax;
    Fighter dave;
    Sword sword;
    Sword sword2;

    @Before
    public void before(){
        healing=new HealingPotion("Gumdrops");
        sword = new Sword("Stabby", 40);
        sword2 = new Sword("Slashy", 10);
        ajax = new Fighter("Ajax", sword, 10, 20, 30);
        dave = new Fighter("Dave", sword2, 10, 20, 50);
    }

    @Test
    public void canGetPotionName(){
        assertEquals(healing.getName(),"Gumdrops");
    }

    @Test
    public void canGetClass(){
       System.out.println(healing.getClass());
    }

    @Test
    public void canHeal(){
        assertEquals(ajax.getHp(),30);
        healing.effect(ajax);
        assertEquals(ajax.getHp(),35);
    }

}
