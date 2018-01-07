package by.itacademy.task3;

import org.junit.Assert;
import org.junit.Test;

public class TestWithdrawalMoney extends Assert{
    private Manager manager = new Manager(new CashMachine(0,0,0));
    private boolean isSuccseed;

    @Test
    public void testNotEnoughMoney(){
        if(manager.withdrawMoney(20)!=null){
            isSuccseed=true;
        }
        assertFalse(isSuccseed);
    }

    @Test
    public void testNotEnoughMoney2(){
        manager.addMoney(1560);
        if(manager.withdrawMoney(2000)!=null){
            isSuccseed=true;
        }
        assertFalse(isSuccseed);
    }

    @Test
    public void testNoSuchNominal(){
        manager.addMoney(1560);
        if(manager.withdrawMoney(10)!=null){
            isSuccseed=true;
        }
        assertFalse(isSuccseed);
    }

    @Test
    public void testNoSuchNominal2(){
        manager.addMoney(100);
        if(manager.withdrawMoney(20)!=null){
            isSuccseed=true;
        }
        assertFalse(isSuccseed);
    }

    @Test
    public void testNoSuchNominal3(){
        manager.addMoney(100);
        if(manager.withdrawMoney(50)!=null){
            isSuccseed=true;
        }
        assertFalse(isSuccseed);
    }


    @Test
    public void testNegativeSum(){
        manager.addMoney(1560);
        if(manager.withdrawMoney(-200)!=null){
            isSuccseed=true;
        }
        assertFalse(isSuccseed);
    }


    @Test
    public void testisOK(){
        manager.addMoney(50);
        manager.addMoney(50);
        if(manager.withdrawMoney(50)!=null){
            isSuccseed=true;
        }
        assertTrue(isSuccseed);
    }

    @Test
    public void testisOK2(){
        manager.addMoney(1570);
        if(manager.withdrawMoney(120)!=null){
            isSuccseed=true;
        }
        assertTrue(isSuccseed);
    }
}
