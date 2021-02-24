import gear.potions.Potion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PotionTest {

    Potion potion;


    @Before

    public void before(){
        potion = new Potion("Shinny" );

    }

    @Test
    public void canPrintToConsole(){
        potion.effect();
    }

}
