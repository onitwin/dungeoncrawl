import characters.Fighter;
import gear.potions.HealingPotion;
import gear.potions.Potion;
import gear.weapons.Sword;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionTest {

    Potion potion;
    Fighter joseph;
    Sword sword;



    @Before

    public void before(){
        potion = new HealingPotion("Shinny" );
        sword =new Sword("Choppy",4);
        joseph= new Fighter("Joseph",sword,20,20,20);

    }

    @Test
    public void canPrintToConsole(){
        potion.effect(joseph);
    }

}
