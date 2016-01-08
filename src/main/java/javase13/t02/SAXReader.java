package javase13.t02;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SAXReader implements ReaderFood {
    private String path;
    public SAXReader(String path) {
        this.path = path;
    }

    @Override
    public boolean analyze() {
        boolean valid = true;
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/validation", true);
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/string-interning", true);
            reader.setErrorHandler(new MyErrorHandler(System.err));
            try( InputStream file = XMLAnalyzer.class.getResourceAsStream(path)) {
                reader.parse(new InputSource(file));
            }
        } catch (org.xml.sax.SAXException e) {
            valid = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;
    }

    @Override
    public ArrayList<Food> parse() {
        return null;
    }

}
