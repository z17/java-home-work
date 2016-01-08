package javase13.t02;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class StAXReader implements ReaderFood {
    String path;

    public StAXReader(String path) {
        this.path = path;
    }

    @Override
    public ArrayList<Food> parse() {

        String currentElementName = null;
        ArrayList<Food> list = new ArrayList<>();
        boolean foodOpen = false;

        Integer id = null;
        String name = null;
        String description = null;
        String price = null;
        Integer calories = null;

        XMLInputFactory inputFactory = XMLInputFactory.newFactory();

        try(InputStream file = XMLAnalyzer.class.getResourceAsStream(path)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(file);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        currentElementName = reader.getLocalName();
                        if (currentElementName.equals("food")) {
                            foodOpen = true;
                            id = Integer.parseInt(reader.getAttributeValue(null, "id"));
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if (currentElementName != null && !text.isEmpty()) {
                            switch (currentElementName) {
                                case "name":
                                    name = text;
                                    break;
                                case "price":
                                    price = text;
                                    break;
                                case "description":
                                    description = text;
                                    break;
                                case "calories":
                                    calories = Integer.parseInt(text);
                                    break;
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        currentElementName = reader.getLocalName();
                        if (currentElementName.equals("food") && foodOpen) {
                            list.add(new Food(id, name, price, description, calories));
                            id = null;
                            name = null;
                            price = null;
                            description = null;
                            calories = null;
                            foodOpen = false;
                        }
                        break;

                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean analyze() {
        // def value
        return false;
    }
}
