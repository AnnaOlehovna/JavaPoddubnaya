package by.itacademy.task1;


import by.itacademy.task1.EntityXML.People;
import by.itacademy.task1.EntityXML.Root;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;

public class Myhandler extends org.xml.sax.helpers.DefaultHandler {

    private String currentElement;
    private Root root;
    private ArrayList<People> peopleList;
    private People people;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Starting parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        switch (currentElement) {
            case "root":
                root = new Root();
                break;
            case "people":
                peopleList = new ArrayList<>();
                break;
            case "element":
                people = new People();
                break;

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "element":
                peopleList.add(people);
                people=null;
                break;
            case "people":
                root.setPeople(peopleList);
                peopleList = null;
                break;
        }
        currentElement=null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (text.contains("<") || currentElement == null) {
            return;
        }
        switch (currentElement) {
            case "name":
                if (root.getName() == null) {
                    root.setName(text);
                } else {
                    people.setName(text);
                }
                break;
            case "age":
                people.setAge(Integer.valueOf(text));
                break;
            case "id":
                people.setId(Integer.valueOf(text));
                break;
            case "isDegree":
                people.setDegree(Boolean.valueOf(text));
                break;
            case "surname":
                people.setSurname(text);
                break;
        }
    }
}
