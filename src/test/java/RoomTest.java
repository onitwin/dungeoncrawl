import characters.Fighter;
import characters.Skeleton;
import dungeon.Room;
import gear.treasure.Coin;
import gear.treasure.Key;
import gear.treasure.Loot;
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
    Skeleton bonesy;
    Skeleton skully;
    Key key;
    Coin coin;


    @Before
    public void before(){
        kitchen=new Room("kitchen",String.format("The kitchen is small and needs cleaned"));
        basement=new Room("basement",String.format("Its damp and dark in the basement"));
        dungeon=new Room("dungeon",String.format("The dungeon has strange implements of torture"));
        bonesy=new Skeleton("Bonesy",sword,5,20,100);
        skully=new Skeleton("Skully",sword,1,2,3);
        sword = new Sword("Stabby", 40);
        ajax = new Fighter("Ajax", sword, 10, 20, 30);
        key = new Key("Boss Room Key", 1);
        coin = new Coin("Golden Ducet", 10);
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

    @Test
    public void checkMonsterArrayEmpty(){
        assertEquals(kitchen.getMonstersSize(),0);
    }

    @Test
    public void canAddMonsters(){
        assertEquals(kitchen.getMonstersSize(),0);
        kitchen.addMonster(bonesy);
        assertEquals(kitchen.getMonstersSize(),1);
    }

    @Test
    public void canGetSpecificMonster(){
        kitchen.addMonster(bonesy);
        kitchen.addMonster(skully);
        assertEquals(kitchen.getSpecificMonster(skully),skully);

    }


    @Test
    public void canGetLootSize(){
        assertEquals(0, kitchen.getLootSize());
    }

    @Test
    public void canAddLoot(){
        assertEquals(0,kitchen.getLootSize());
        kitchen.addLoot(key);
        assertEquals(1,kitchen.getLootSize());
    }

    @Test
    public void canPassLoot(){
        kitchen.addLoot(key);
        kitchen.addLoot(coin);
        assertEquals(kitchen.getLootSize(), 2);
        assertEquals(ajax.getEquipmentSize(),0);
        kitchen.canPassLoot(key);
        assertEquals(kitchen.getLootSize(), 1);
        assertEquals(ajax.getEquipmentSize(),1);

    }
//
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
