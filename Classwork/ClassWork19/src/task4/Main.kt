package task4

import task3.Student


fun  main(arg: Array<String>){

    System.out.println("asd")

    var student: Int = 5 //конкретизировать тип не обязательно


    val student2 = "sdf"// final - нельзя менять

    student=8
    

    val list = listOf<String>() // Неизменяемый лист


    test(name = "asdf", title = "uiug")

}

fun test(title: String, name: String): String{

    return title
}
