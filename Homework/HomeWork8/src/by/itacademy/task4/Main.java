package by.itacademy.task4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

       Manager manager=new Manager();
       Student[] students = createStudents();
       printStud(students);
       manager.averageAge(students);
       printAverageAge(manager.averageAge(students));

    }

    private static Student[] createStudents() {
        Manager manager = new Manager();
        Student[] stud=null;
        String path = new File("").getAbsolutePath();
        File studentsFile = new File(path + "\\students.txt");
        if (studentsFile.exists()) {
            int numberOfLines = 0;
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(studentsFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bf = new BufferedReader(fileReader);
            try {
                while (bf.readLine() != null) {
                    numberOfLines++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            stud = new Student[numberOfLines];
            Scanner scanner = null;
            try {
                scanner = new Scanner(studentsFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < stud.length; i++) {
                stud[i] = new Student();
                if (scanner != null) {
                    stud[i].setSurName(scanner.next());
                    stud[i].setName(scanner.next());
                    stud[i].setBirthDay(manager.stringToDate(scanner.next()));
                }
            }
        } else {
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(studentsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Введите число студентов");
            stud = new Student[addInt()];
            for (int i = 0; i < stud.length; i++) {
                stud[i] = new Student();
                System.out.println("Введите Фамилию " + (i + 1) + " студента");
                String surname = addString();
                stud[i].setSurName(surname);
                System.out.println("Введите Имя " + (i + 1) + " студента");
                String name = addString();
                stud[i].setName(name);
                System.out.println("Введите дату рождения " + (i + 1) + " студента в формате дд-мм-гггг");
                String birth = addString();
                stud[i].setBirthDay(manager.stringToDate(birth));
                try {
                    if (fileWriter != null) {
                        fileWriter.write(surname + " " + name + " " + birth + "\r\n");
                        fileWriter.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stud;
    }

    private static String addString() {
        String inputString = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            e.getMessage();
        }
        return inputString;
    }


    private static int addInt() {
        int inputInt = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputInt = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.getMessage();
        }
        return inputInt;
    }

    private static void printStud(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(students[i].getSurName() + " " + students[i].getName() + " " + sdf.format(students[i].getBirthDay()));
        }
    }

    private static void printAverageAge(int[] yearMonth) {
        String s1 = null;
        String s2 = null;
        if (yearMonth[0] % 10 == 1) {
            s1 = "Средний возраст студентов: " + yearMonth[0] + " год ";
        } else if (yearMonth[0] % 10 == 2 || yearMonth[0] % 10 == 3 || yearMonth[0] % 10 == 4) {
            s1 = "Средний возраст студентов: " + yearMonth[0] + " года ";
        } else {
            s1 = "Средний возраст студентов: " + yearMonth[0] + " лет ";
        }
        if (yearMonth[1] == 0) {
            s2 = "";
        } else if (yearMonth[1] == 2 || yearMonth[1] == 3 || yearMonth[1] == 4) {
            s2 = yearMonth[1] + " месяца.";
        } else {
            s2 = yearMonth[1] + " месяцев.";
        }
        System.out.println(s1 + s2);

    }


}
