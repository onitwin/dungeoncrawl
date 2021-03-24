import characters.Fighter;
import characters.Monster;
import characters.Skeleton;
import dungeon.Room;
import gear.potions.HealingPotion;
import gear.potions.Potion;
import gear.weapons.Sword;
import logic.AttackOptions;
import org.junit.Before;

import java.util.ArrayList;

public class AttackOptionsTest {
    AttackOptions atkOptions;
    Fighter ajax;
    Sword sword;
    Sword sword2;
    HealingPotion beetleJuice;
    Room room;
    Skeleton bonesy;
    Skeleton skully;
    ArrayList<Monster> baddies;

    @Before
    public void before() {
        sword = new Sword("Stabby", 40);
        sword2 = new Sword("Slashy", 10);
        ajax = new Fighter("Ajax", sword, 10, 20, 30);
        ajax.addEquipment(sword2);
        ajax.addEquipment(beetleJuice);
        bonesy=new Skeleton("Bonesy",sword,5,20,100);
        skully=new Skeleton("Bonesy",sword,5,20,100);
        baddies = new ArrayList<Monster>();
        baddies.add(bonesy);
        baddies.add(skully);
        beetleJuice = new HealingPotion("Beetle Juice");
        room = new Room("Kitchen", "Needs cleaned");
        atkOptions = new AttackOptions(ajax, baddies );
    }
}
