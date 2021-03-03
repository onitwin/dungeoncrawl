import characters.Fighter;
import dungeon.Room;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RoomTest {
    Room kitchen;
    Sword sword;
    Fighter ajax;


    @Before
    public void before(){
        kitchen=new Room("kitchen",String.format("The kitchen is small and needs cleaned"));
        sword = new Sword("Stabby", 40);
        ajax = new Fighter("Ajax", sword, 10, 20, 30);
    }

    @Test
    public void canGetRoomname(){
        assertEquals("kitchen",kitchen.getRoomname());
    }

    @Test
    public void canGetDescription(){
        assertEquals("The kitchen is small and needs cleaned",kitchen.getDescription());
    }

    @Test
    public void startsWithNoPlayer(){
        assertNull(kitchen.getPlayer());
    }

    @Test
    public void canAddPlayer(){
        assertNull(kitchen.getPlayer());
        kitchen.addPlayer(ajax);
        assertEquals(kitchen.getPlayer(),ajax);
    }
}
