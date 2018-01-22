package by.itacademy

fun main(arg: Array<String>) {

    var student = Student()
    student.name="yrfeyrf";
    student.age=565



    var g: Int? = null;

    var e: Byte = g?.toByte() ?: 25 //если null - То будет равно 25

    //  g.compareTo(2.5) - так ругается

    g?.compareTo(2.5)//если g равно null, то эта строка просто не выполнится

    g!!.compareTo(2.5)//означает, что если null и нам это надо, то он даст NullPointer



    var list: MutableList<String>

    var number = 5;
    number = 10;

    test(number)

    val i = 50

    when (i) {//это switch, брейки не нужны
        in 10..40 -> {//можно задавать интервалы
        }
        50 -> {
        }
        else -> {
        }
    }

    for(a in arg){
        //сокращенный foreach
    }

}

fun test(value: Int) {
    //параметр в методе всегда val - нельзя менять
    //поэтому ошибкой будет value = 20
    println("jkjhkhj" + value);
}
