import gear.weapons.DamageType;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    Sword sword;


    @Before
    public void before() {
        sword = new Sword("Stabby", 5);
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
        sword.effect();
        assertEquals(DamageType.STAB, sword.getDamageType());
        sword.effect();
        assertEquals(DamageType.SLASH, sword.getDamageType());
    }
}
