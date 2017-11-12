public class Main {

    public static void main(String[] args) {
        // 1.  Создайте переменную типа String c любым текстом (не сильно короткое).
        // Далее выведите на экран количество символов в данной строке.
        // Далее разделите строку пополам (если ровно поделить не выходит то +-1 не страшно),
        // в результате у вас должно быть 2-е новых переменных типа String с частями из изначальной строки.
        // Полученные строки выведите на экран.

        String text = "В воскресенье не хочется ничего не делать. А я сходила на тренировку и взялась за домашку. Кто молодец?! Я молодец!";
        int size = text.length();
        System.out.println("Длина строки text равна " + size);
        int half = size / 2;
        String text1 = text.substring(0, size / 2);
        String text2 = text.substring(size / 2);
        System.out.println(text1);
        System.out.println(text2);

        //2. Создайте любое число. Определите, является ли последняя цифра числа семеркой.

        System.out.println("***************");
        int number = 12349;
        if (number % 10 == 7) {
            System.out.println("Последняя цифра числа является семеркой.");
        } else {
            System.out.println("Последняя цифра числа НЕ является семеркой.");
        }

        //3. Имеется прямоугольное отверстие размерами a и b (размеры задать любые),
        // определить, можно ли его полностью закрыть круглой картонкой радиусом r (тоже подставляем любое значение).

        System.out.println("***************");
        double a = 4.0;
        double b = 15.0;
        double r = 7.0;
        double c = Math.sqrt((a * a) + (b * b));
        if (r >= (c / 2)) {
            System.out.println("Круглая картонка с радиусом " + r + " полностью закроет прямоугольник с размерами " + a + " и " + b + ".");
        } else {
            System.out.println("Круглая картонка с радиусом " + r + " не сможет полностью закрыть прямоугольник с размерами " + a + " и " + b + ".");
        }

        //4. Имеется целое число (любое), это число — сумма денег в рублях.
        // Вывести это число, добавив к нему слово «рублей» в правильном падеже.

        System.out.println("***************");
        int money = 16;
        int q = money % 10;
        if (money == 11 || money == 12 || money == 13 || money == 14) {
            System.out.println(money + " рублей.");
        } else {
            switch (q) {
                case 1: {
                    System.out.println(money + " рубль.");
                    break;
                }
                case 2:
                case 3:
                case 4: {
                    System.out.println(money + " рубля.");
                    break;
                }
                default:
                    System.out.println(money + " рублей.");
            }
        }

        //5. Имеется строка, которая содержит символы ? и символы #.
        // Замените все символы ? на HELLO, а # - удалите. Результат вывести на экран.

        System.out.println("***************");

        String symbols = "##?##??";
        String hello0 = symbols.replace("?", "HELLO");
        String hello1 = hello0.replace("#", "");
        System.out.println(hello1);

        //Задание для тех у кого еще есть время и все остальное далось легко (делать не обязательно):
        // Сделать расчет выражения (x подставляем сами):

        System.out.println("***************");
        double x = 1.0;
        double t = 2.0;
        double s = 3.0;
        double numerator = Math.pow(Math.sin(Math.pow(x, t)), 2);
        double denominator = Math.sqrt((1 + Math.pow(x, s)));
        double y = numerator / denominator;
        System.out.printf("В результате y равен %.5f%n", y);

    }
}
