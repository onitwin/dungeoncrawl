import characters.Fighter;
import gear.weapons.DamageType;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    Sword sword;
    Fighter ajax;
    Fighter dave;


    @Before
    public void before() {
        sword = new Sword("Stabby", 5);
        ajax = new Fighter("Ajax", sword, 10, 20, 30);
        dave = new Fighter("Dave", sword, 10, 20, 50);
    }

    @Test
    public void canGetName(){
        assertEquals("Stabby", sword.getName());
    }

    @Test
    public void canGetDamage(){
        assertEquals(5, sword.getDamage());
    }

    @Test
    public void canGetDamageType(){
        assertEquals(DamageType.SLASH, sword.getDamageType());
    }

    @Test
    public void canUseEffect(){
        assertEquals(DamageType.SLASH, sword.getDamageType());
       assertEquals( ajax.getHp(),30);
        sword.effect(ajax);
        assertEquals( ajax.getHp(),27);


    }
}
