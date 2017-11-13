public class Main {

    public static void main(String[] args) {

        int[] array = new int[5];
        array[0] = 16;
        array[1] = 5;
        array[2] = 10;
        array[3] = 15;
        array[4] = 20;

//        System.out.println(array[1]);

//
//        for(int i = array.length-1;i>=0; i--){
//            System.out.println("i= "+i);
//            System.out.println(array[i]);
//        }
//
//        for(int value:array){
//            System.out.println(value);//скоращенный for
//        }
////
////        int i =0;
//        while(i<array.length){
//            System.out.println(array[i]);
//            i++;
//        }


        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        double avg = (double)sum / array.length;
        System.out.println(avg);


        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("min = " + min);

        System.out.println(args[0]);




    }
}
