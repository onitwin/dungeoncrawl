import characters.Fighter;
import characters.Skeleton;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkeletonTest {
    Skeleton bonesy;
    Sword sword;
    Sword sword2;
    Fighter dave;

    @Before
    public void before(){
        sword = new Sword("Stabby", 40);
        sword2 = new Sword("Slashy", 10);
        bonesy=new Skeleton("Bonesy",sword,5,20,100);
        dave = new Fighter("Dave", sword2, 10, 20, 50);
    }

    @Test
    public void canGetName(){
        assertEquals(bonesy.getName(),"Bonesy");
    }

    @Test
    public void canGetWeapon(){
        assertEquals(bonesy.getWeapon(),sword);
    }

    @Test
    public void canGetAtk(){
        assertEquals(bonesy.getAtk(),5);
    }

    @Test
    public void canGetHp(){
        assertEquals(bonesy.getHp(),100);
    }

    @Test
    public void canGetDef(){
        assertEquals(bonesy.getDef(),20);
    }

    @Test
    public void canAttack(){
        assertEquals(50, dave.getHp());
        bonesy.attack(dave);
        assertEquals(25,dave.getHp());
    }
}
