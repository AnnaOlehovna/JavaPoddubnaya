package by.itacademy.task1;

import java.util.*;

/**
 * Created by user on 11.12.2017.
 */
public class Main {
    public static void main(String[] args) {

        Set<String> testSet = new HashSet<>();
//        testSet.add("AAA");
//        testSet.add("SSS");
//        testSet.add("AAA");
//        for(String  test: testSet){
//            System.out.println("value = "+test);
//        }

        List<String > list = new ArrayList<>();
        list.add("AAA");
        list.add("SSS");
        list.add("AAA");

        testSet.addAll(list);
        list.clear();
        list.addAll(testSet);


        Set<Student> testSet2 = new HashSet<>();
        testSet2.add(new Student("AAA",25));
        testSet2.add(new Student("DDD",20));
        testSet2.add(new Student("AAA",28));

        //Ключ не может повторяться - он определящиюй
        Map<String, String> testMap = new HashMap<>();
        testMap.put("RU"," RU Value");
        testMap.put("BY","BY Value2");
        testMap.put("EN","EN Value");
        testMap.put("FR","FR Value3");

        System.out.println("VALUE = "+testMap.get("RU"));






    }
}
