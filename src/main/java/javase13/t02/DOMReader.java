package javase13.t02;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import javase01.t04.Array;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DOMReader implements ReaderFood {
    private String path;

    public DOMReader(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<Food> parse() {
        ArrayList<Food> list = new ArrayList<>();

        DOMParser parser = new DOMParser();
        try (InputStream file = XMLAnalyzer.class.getResourceAsStream(path)) {
            parser.parse(new InputSource(file));
            Document document = parser.getDocument();
            Element root = document.getDocumentElement();
            NodeList nodes = root.getElementsByTagName("food");
            for(int i = 0; i < nodes.getLength(); i++) {
                Element current = (Element) nodes.item(i);
                int id = Integer.parseInt(current.getAttribute("id"));
                String name = current.getElementsByTagName("name").item(0).getTextContent().trim();
                String price = current.getElementsByTagName("price").item(0).getTextContent().trim();
                String description = current.getElementsByTagName("description").item(0).getTextContent().trim();
                int calories = Integer.parseInt(current.getElementsByTagName("calories").item(0).getTextContent().trim());
                list.add(new Food(id, name, price, description, calories));
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean analyze() {
        return false;
    }
}
