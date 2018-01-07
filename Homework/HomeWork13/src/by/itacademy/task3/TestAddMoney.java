package by.itacademy.task3;

import org.junit.Assert;
import org.junit.Test;

public class TestAddMoney extends Assert{

    Manager manager = new Manager(new CashMachine(0,0,0));



    @Test
    public void testNoSuchNominale1(){
        boolean result = manager.addMoney(10);
        assertFalse(result);
    }

    @Test
    public void testNoSuchNominale2(){
        boolean result = manager.addMoney(105);
        assertFalse(result);
    }

    @Test
    public void testNegativeSum(){
        boolean result = manager.addMoney(-100);
        assertFalse(result);
    }

    @Test
    public void testOK(){
        boolean result = manager.addMoney(20);
        assertTrue(result);
    }

    @Test
    public void testOK2(){
        boolean result = manager.addMoney(160);
        assertTrue(result);
    }


}
