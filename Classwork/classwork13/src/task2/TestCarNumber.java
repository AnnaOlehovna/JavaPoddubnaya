package task2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 03.01.2018.
 */
public class TestCarNumber extends Assert{


    @Before
    public void beforeTest(){
        //вызовется до запуска всех тестов
        //можно здесь инициализировать данные
    }

    @Test
    public void testCarNumber(){
        boolean result = Main.checkCarNumber("2050 OP-7");
        assertTrue(result);
    }


    @Test
    public void testCarNumber2(){
        boolean result = Main.checkCarNumber("2150 TR-2");
        assertTrue(result);

    }

    @Test
    public void testCarNumber3(){
        boolean result = Main.checkCarNumber("20506 OP-7");
        assertFalse(result);//заведомо ошибочные данные и result должен быть false

    }

    @After
    public void afterTest(){
        //вызывается после всех тестов
        //можно здесь обнулять данные
    }
}
