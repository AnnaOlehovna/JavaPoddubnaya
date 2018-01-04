package task2;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by user on 03.01.2018.
 */
public class TestPhoneNumber extends Assert {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testPhoneNumber(){
        boolean result = Main.checkPhoneNumber("+375291118987");
        assertTrue(result);
    }


    @Test
    public void testPhoneNumber2(){
        boolean result = Main.checkPhoneNumber("+375331118979");
        assertTrue(result);
    }

    @Test
    public void testPhoneNumber3(){
        boolean result = Main.checkPhoneNumber("+375251118987");
        assertTrue(result);
    }

    @Test
    public void testPhoneNumber4(){
        boolean result = Main.checkPhoneNumber("+3752911189870");
        assertFalse(result);
    }

    @Test
    public void testPhoneNumber5(){
        boolean result = Main.checkPhoneNumber("376291118987");
        assertFalse(result);
    }

    @Test
    public void testPhoneNumber6(){
        expectedException.expect(NullPointerException.class);
        Main.checkPhoneNumber(null);

    }
}
