package by.itacademy.task1;


import by.itacademy.task1.Entity.People;
import by.itacademy.task1.Entity.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String LINK = "http://kiparo.ru/t/test.xml";

    public static void main(String[] args) {

        InputStream inputStream = null;

        FileOutputStream fileOutputStream= null;

        try{

            URL url = new URL(LINK);
            HttpURLConnection httpURLConnection =
                    (HttpURLConnection)url.openConnection();

            int responseCode = httpURLConnection.getResponseCode();

            if(responseCode==HttpURLConnection.HTTP_OK){

                inputStream = httpURLConnection.getInputStream();

                File file = new File("test.xml");
                fileOutputStream = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[2048];
                while((byteRead = inputStream.read(buffer))!=-1){
                    fileOutputStream.write(buffer,0,byteRead);

                    parseXml();

                }
            }else {
                System.out.println("Данные не найдены, response code = "+responseCode);
            }

        }catch (Exception e){
            System.out.println("Невозможно скачать файл. Ошибка "+e.toString());
        }finally {
            if(inputStream!=null&&fileOutputStream!=null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Невозможно закрыть inputStream. Ошибка "+e.toString());
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    System.out.println("Невозможно закрыть fileOutputStream. Ошибка "+e.toString());
                }
            }
        }
    }



    public static void parseXml(){

        Document dom;

        try{

            //открываем xml файл;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            dom = builder.parse("test.xml");


        }catch (Exception e){
            System.out.println("Невозможно открыть xml, error = "+e.toString());
            return;
        }

        //наш объект, который мы будем заполнять данными из xml;
        Root root = new Root();

        //======= парсинг xml =======

        //получаем главный, самый первый элемент из файла
        Element rootElement = dom.getDocumentElement();
        System.out.println("root tag name = "+rootElement.getTagName());

        //получаем следующий элемент по названию, в данном случае тег  name;
        NodeList nameNodeList = rootElement.getElementsByTagName("name");

        //так как в теге может быть много других тегов, мы изначально получаем массив
        //так как мы знаем, что у нас нет содержимого в name
        //берем первый элемент
        Node nameNode = nameNodeList.item(0);
        System.out.println("name tag = "+nameNode.getNodeName());

        //получаем содержимого тега name
        String nameFile = nameNode.getTextContent();
        System.out.println("name tag = "+nameNode.getTextContent());

        //заполняем наш объект Root
        root.setName(nameFile);

        //======парсим people=======

        //получаем следующий элемент по названию, в данном случае тег  people;
        NodeList peopleNodeList = rootElement.getElementsByTagName("people");
        Node peopleNode = peopleNodeList.item(0);

        //получаем из тега people все содержимое, т.е. массив элементов element
        //один элемент из elementsNodeList - это один тег element
        NodeList elementsNodeList = peopleNode.getChildNodes();
        List<People> listPeople = new ArrayList<>();

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
            System.out.println("id = "+id);
            People people = new People(id,name,surname,age,isDegree);

            listPeople.add(people);

        }

        root.setPeople(listPeople);
        System.out.println("===========");

        System.out.println("Root = "+root.toString());




    }
}
