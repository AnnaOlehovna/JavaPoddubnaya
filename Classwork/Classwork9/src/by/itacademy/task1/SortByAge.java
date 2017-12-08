package by.itacademy.task1;

import java.util.Comparator;

/**
 * Created by user on 08.12.2017.
 */
public class SortByAge implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge()==o2.getAge()) return 0;
        if(o1.getAge()>o2.getAge()) return 1;
        return -1;
    }
}
