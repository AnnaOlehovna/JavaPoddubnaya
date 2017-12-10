package by.itacademy.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Manager  {

    private Student[] students;

    public Manager() {
    }

    public Manager(Student[] students) {
        this.students = students;
    }

  /**
   * Переводит String с датой рожения в тип Date
   *
   * @param stringBirthday - тип String
   * @return - тип Date
   */
   public  Date stringToDate(String stringBirthday) {
        Date birthday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            birthday = sdf.parse(stringBirthday);
        } catch (ParseException e) {
            e.getMessage();
        }
        return birthday;
    }

    /**
     * Рассчитывает средний возраст студентов по дате рождения
     *
     * @param students - тип Student[]
     * @return - int[] - средний возраст в годах и месяцах
     */
    public int[] averageAge(Student[] students) {
        int[] diffYearMonth = new int[2];
        GregorianCalendar nowadays = new GregorianCalendar();
        int currentYear = nowadays.get(GregorianCalendar.YEAR);
        int currentMonth = nowadays.get(GregorianCalendar.MONTH)+1;
        int averageYear = 0;
        int averageMonth = 0;
        for (int i = 0; i < students.length; i++) {
            GregorianCalendar studentBirth = new GregorianCalendar();
            studentBirth.setTime(students[i].getBirthDay());
            int birthdayYear = studentBirth.get(GregorianCalendar.YEAR);
            int birthdayMonth = studentBirth.get(GregorianCalendar.MONTH)+1;
            if (currentMonth < birthdayMonth) {
                currentYear = -1;
                currentMonth = +12;
            }
            int diffMonth = currentMonth - birthdayMonth;
            int diffYear = currentYear - birthdayYear;
            averageMonth = averageMonth + diffMonth;
            averageYear = averageYear + diffYear;
        }
        int reminder = averageYear%students.length;
        averageYear=averageYear/students.length;
        averageMonth=(averageMonth+reminder*12)/students.length;
        if(averageMonth>=12){
            averageYear=+1;
            averageMonth=-12;
        }



        diffYearMonth[0] = averageYear;
        diffYearMonth[1] = averageMonth;
        return diffYearMonth;
    }

}
