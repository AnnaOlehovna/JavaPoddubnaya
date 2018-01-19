package task3;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;


public class Main {

    private static Student student = new Student(); // -сильная ссылка - не удаляется пока последняя ссылка на объект не отработает

    // sortReference - сборщик мусора в java может удалить такой объект из-за нехватки памяти
    private static SoftReference<Student> studentSoftReference = new SoftReference<Student>(new Student());


    private static WeakReference<Student> studentWeakReference = new WeakReference<Student>(student);

    public static void main(String[] args) {

        Student student = studentSoftReference.get();

    }
}
