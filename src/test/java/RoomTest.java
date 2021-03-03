import characters.Fighter;
import dungeon.Room;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.*;

public class RoomTest {
    Room kitchen;
    Room basement;
    Room dungeon;
    Sword sword;
    Fighter ajax;


    @Before
    public void before(){
        kitchen=new Room("kitchen",String.format("The kitchen is small and needs cleaned"));
        basement=new Room("basement",String.format("Its damp and dark in the basement"));
        dungeon=new Room("dungeon",String.format("The dungeon has strange implements of torture"));

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


    @Test
    public void canPassPlayer(){
        kitchen.addPlayer(ajax);
        assertEquals(kitchen.getPlayer(),ajax);
        kitchen.passPlayer(basement);
        assertNull(kitchen.getPlayer());
        assertEquals(basement.getPlayer(),ajax);
    }

    @Test
    public void roomStartsUnvisited(){
        assertEquals(kitchen.visitedStatus(), false);

    }

    @Test
    public void visitedStatusUpdatesWhenPlayerEnters(){
        assertEquals(kitchen.visitedStatus(), false);
        kitchen.addPlayer(ajax);
        assertEquals(kitchen.getPlayer(),ajax);
        assertEquals(basement.visitedStatus(), false);
        kitchen.passPlayer(basement);
        assertNull(kitchen.getPlayer());
        assertEquals(basement.visitedStatus(), true);
        assertNotNull(basement.getPlayer());
        assertEquals(kitchen.visitedStatus(), true);
    }

    @Test
    public void getRoomExits(){
        kitchen.addExits("North",dungeon);
        kitchen.addExits("West",basement);
        assertEquals(2,kitchen.getExitSize());
    }

//    @Test
//    public void getExitsKey(){
//        kitchen.addExits("North",dungeon);
//        kitchen.addExits("West",basement);
//        Set results = kitchen.getExits().keySet();
//        System.out.println(results);
//        for(Object key : results){
//            System.out.println(key.getClass());
//            System.out.println(key);
//        }
//    }






}
