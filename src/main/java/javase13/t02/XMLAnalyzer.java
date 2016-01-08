package javase13.t02;

public class XMLAnalyzer {

    private static final String XML_PATH = "/javase13/t02/in.xml";

    public static void main(String[] args) {

        SAXReader sax = new SAXReader(XML_PATH);
        boolean valid = sax.analyze();
        System.out.println("SAX:");
        if (valid) {
            System.out.println("SAX: valid xml");
        } else {
            System.out.println("SAX: invalid xml");
        }
        System.out.println(sax.parse());
        System.out.println();

        System.out.println("StAX:");
        StAXReader stax = new StAXReader(XML_PATH);
        System.out.println(stax.parse());
        System.out.println();

        System.out.println("DOM:");
        DOMReader dom = new DOMReader(XML_PATH);
        System.out.println(dom.parse());
    }


}