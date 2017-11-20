//рассмотреть в методах с похожими типами входными данными (лонг, инт, дабл) какой именно вызовется

public class Main {

    public static void main(String[] args) {
        //если тип данных с большой буквы то использовать equals

        final String tratata="1245";// переменная становится константой и ее значение нельзя изменить

	Integer a=new Integer(10);
        Integer b=new Integer(10);

        if(a==b){
            System.out.println(" TRUE");
            }else{
            System.out.println(" FALSE");
        }
        if(a.equals(b)){
            System.out.println("1 TRUE");
        }else{
            System.out.println("1 FALSE");
        }

        Integer a1=127;
        Integer b1=127;

        if(a==b){
            System.out.println("2 TRUE");//сработает в диапазоне от-128 до 127
        }else{
            System.out.println("2 FALSE");
        }

        String a2=new String("hello");
        String b2=new String("hello");

        if(a2==b2){
            System.out.println("3 TRUE");
        }else{
            System.out.println("3 FALSE");
        }
        String a3="hello";
        String b3="hello";

        if(a3==b3){
            System.out.println("4 TRUE");
        }else{
            System.out.println("4 FALSE");
        }


    }
}
