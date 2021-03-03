import characters.Fighter;
import characters.Player;
import gear.treasure.Key;
import gear.treasure.Loot;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyTest {

    private Key key;
    private Player dave;
    private Sword sword2;




    @Before
    public void before(){

        key = new Key("Boss Room Key", 10);
        dave = new Fighter("Dave", sword2, 10, 20, 50);
        sword2 = new Sword("Slashy", 10);


    }

    @Test
    public void canGetName(){
        assertEquals("Boss Room Key", key.getName());
    }

    @Test
    public void  canGetValue(){
        assertEquals(10, key.getValue());
    }

    @Test
    public void canSetName(){
        assertEquals("Boss Room Key", key.getName());
        key.setName("New Key");
        assertEquals("New Key", key.getName());
    }

    @Test
    public void canSetValue(){
        assertEquals(10, key.getValue());
        key.setValue(1);
        assertEquals(1, key.getValue());

    }

    @Test
    public void canUseEffect(){
        key.effect(dave);

    }


}
