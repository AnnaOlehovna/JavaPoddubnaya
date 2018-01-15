package by.itacademy.task2;


import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
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
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static ArrayList<File> fileList = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            File currentfile = new File(args[i]);
            fileList = fileArray(currentfile);
        }
        for (File currentFile : fileList) {

            System.out.println(currentFile.getAbsoluteFile());
        }
        toXML();
    }


    /**
     * Создание ArrayList fileList с раширением .txt
     * @param
     * @return
     */
    public static ArrayList<File> fileArray(File inFile) {
        File[] files = inFile.listFiles();
        for (File file : files) {

            if (file.isDirectory()) {
                fileArray(file);
                continue;
            }
            String path = file.getAbsolutePath();
            Pattern pattern = Pattern.compile(".*\\.(txt)$");
            Matcher matcher = pattern.matcher(path);

            if ((matcher.matches())) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    /**
     * Создание XML из  ArrayList fileList
     */
    public static void toXML() {
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Element files1 = document.createElement("files1");
        document.appendChild(files1);

        for (File currentfile : fileList) {
            Element file = document.createElement("file");
            files1.appendChild(file);

            Element name = document.createElement("name");
            name.setTextContent(currentfile.getName());
            file.appendChild(name);

            Element path = document.createElement("path");
            path.setTextContent(currentfile.getAbsolutePath());
            file.appendChild(path);

            Element size = document.createElement("size");
            size.setTextContent(Long.toString(currentfile.length()));
            file.appendChild(size);

            Element datetime = document.createElement("datetime");
            Path filePath = Paths.get(currentfile.getAbsolutePath());
            BasicFileAttributes attr = null;
            try {
                attr = Files.readAttributes(filePath, BasicFileAttributes.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            datetime.setTextContent(String.valueOf(attr.creationTime()));
            file.appendChild(datetime);
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
}

