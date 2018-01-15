package by.itacademy.task2;


import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static HashMap<String, ArrayList<String>> fileHashMap = new HashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            File currentfile = new File(args[i]);
            fileHashMap = fileArray(currentfile);
        }
        System.out.printf(fileHashMap.entrySet().toString());
        toXML();
        }




    /**
     * Создание HashMap<String, ArrayList<String>> fileHashMap с ключом - раширение файла, значение ArrayList - полный путь файла
     * @param
     * @return
     */
    public static HashMap<String, ArrayList<String>> fileArray(File inFile) {
        File[] files = inFile.listFiles();
        for (File file : files) {

            if (file.isDirectory()) {
                fileArray(file);
                continue;
            }

            String path = file.getAbsolutePath();
            Pattern pattern = Pattern.compile("^(.)+\\.([a-zA-z0-9]{3,5})$");
            Matcher matcher = pattern.matcher(path);

            if (matcher.matches()) {
                String ext = matcher.group(2).toLowerCase();

                if(fileHashMap.containsKey(ext)){
                    fileHashMap.get(ext).add(path);
                }else{
                    ArrayList<String> pathList = new ArrayList<>();
                    pathList.add(path);
                    fileHashMap.put(ext,pathList);
                }
            }
        }
        return fileHashMap;
    }

    /**
     * Создание XML из  HashMap<String, ArrayList<String>> fileHashMap
     */
    public static void toXML() {
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Element files = document.createElement("files");
        document.appendChild(files);

        for ( HashMap.Entry<String, ArrayList<String>> entry: fileHashMap.entrySet()) {

            Element ext = document.createElement("ext");
            Attr name = document.createAttribute("name");
            name.setTextContent(entry.getKey());
            ext.setAttributeNode(name);

            for (String absolutepath: entry.getValue()){
                Element file = document.createElement("file");
                file.setTextContent(absolutepath);
                ext.appendChild(file);
            }
            files.appendChild(ext);

        }
        try {

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("myXML.xml"));
            try {
                transformer.transform(source,result);
            } catch (TransformerException e) {
                e.printStackTrace();
            }


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }
}

