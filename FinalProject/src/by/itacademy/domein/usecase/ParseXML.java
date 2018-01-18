package by.itacademy.domein.usecase;

import by.itacademy.domein.Entity.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ParseXML implements Parsing {
    @Override
    public void parsingFile(File file) {

    Document dom;

        try{

        //открываем xml файл;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        dom = builder.parse(file);

    }catch (Exception e){
        System.out.println("Невозможно открыть xml, error = "+e.toString());
        return;
    }

    //наш объект, который мы будем заполнять данными из xml;
    Root root = new Root();

    //======= парсинг xml =======

    //получаем главный, самый первый элемент из файла
    Element rootElement = dom.getDocumentElement();

    //получаем следующий элемент по названию, в данном случае тег  name;
    NodeList dateNodeList = rootElement.getElementsByTagName("date");

    //так как в теге может быть много других тегов, мы изначально получаем массив
    //так как мы знаем, что у нас нет содержимого в name
    //берем первый элемент
    Node dateNode = dateNodeList.item(0);

    //получаем содержимого тега name
    String dateRoot = dateNode.getTextContent();
    Date date = convertStringtoDate(dateRoot);
    root.setDate(date);


    //заполняем наш объект Root


    //======парсим people=======

    //получаем следующий элемент по названию, в данном случае тег  people;
    NodeList peopleNodeList = rootElement.getElementsByTagName("people");
    Node peopleNode = peopleNodeList.item(0);

    //получаем из тега people все содержимое, т.е. массив элементов element
    //один элемент из elementsNodeList - это один тег element
    NodeList elementsNodeList = peopleNode.getChildNodes();
//    List<People> listPeople = new ArrayList<>();

    //обходим всех people, в xml это element
        for(int i = 0; i <  elementsNodeList.getLength();i++){

        Node node = elementsNodeList.item(i);

        if(node.getNodeType()!= Node.ELEMENT_NODE){
            continue;
        }

        Element element = (Element) node;
        //вытягиваем name
        String name = element.getElementsByTagName("name").item(0).getTextContent();
        System.out.println("name = "+name);
        //вытягиваем surname
        String surname = element.getElementsByTagName("surname").item(0).getTextContent();
        System.out.println("surname = "+surname);
        //вытягиваем isDegree
        boolean isDegree =Boolean.valueOf(element.getElementsByTagName("isDegree").item(0).getTextContent());
        System.out.println(isDegree);
        //вытягиваем age
        int age =Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()) ;
        System.out.println("age = "+age);
        //вытягиваем id
        int id =Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()) ;
//        System.out.println("id = "+id);
//        People people = new People(id,name,surname,age,isDegree);
//
//        listPeople.add(people);

    }

//        root.setPeople(listPeople);
        System.out.println("===========");

        System.out.println("Root = "+root.toString());




}

private Date convertStringtoDate(String string){
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss +Z", Locale.getDefault());
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    try {
        date = sdf.parse(string);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return date;
    }

}
