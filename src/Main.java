import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // Creating handler
        SAXPars handler = new SAXPars();

        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();

        // Pasring from URL
        parser.parse("http://www.geoplugin.net/xml.gp?base_currency=USD",  handler);

        // Printing elements
        System.out.println("\n==================================================\n"
                + "Root element: " + handler.myClass.getRootElement() + "\n");

        System.out.println(handler.myClass);

    }

}


class SAXPars extends DefaultHandler{

    MyClass myClass = new MyClass();
    private String thisElement = "";
    private String rootElement = "";

    @Override
    public void startDocument() {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        thisElement = qName;
        if (rootElement.equals("")) rootElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (thisElement.equals("geoplugin_request")) {
            myClass.setGeoplugin_request(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_status")) {
            myClass.setGeoplugin_status(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("geoplugin_delay")) {
            myClass.setGeoplugin_delay(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_credit")) {
            myClass.setGeoplugin_credit(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_city")) {
            myClass.setGeoplugin_city(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_region")) {
            myClass.setGeoplugin_region(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_regionCode")) {
            myClass.setGeoplugin_regionCode(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_regionName")) {
            myClass.setGeoplugin_regionName(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_areaCode")) {
            myClass.setGeoplugin_areaCode(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_dmaCode")) {
            myClass.setGeoplugin_dmaCode(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_countryCode")) {
            myClass.setGeoplugin_countryCode(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_countryName")) {
            myClass.setGeoplugin_countryName(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_inEU")) {
            myClass.setGeoplugin_inEU(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_euVATrate")) {
            myClass.setGeoplugin_euVATrate(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_continentCode")) {
            myClass.setGeoplugin_continentCode(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_continentName")) {
            myClass.setGeoplugin_continentName(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_latitude")) {
            myClass.setGeoplugin_latitude(new Double(new String(ch, start, length)));
        }
        if (thisElement.equals("geoplugin_longitude")) {
            myClass.setGeoplugin_longitude(new Double(new String(ch, start, length)));
        }
        if (thisElement.equals("geoplugin_locationAccuracyRadius")) {
            myClass.setGeoplugin_locationAccuracyRadius(new Double(new String(ch, start, length)));
        }
        if (thisElement.equals("geoplugin_timezone")) {
            myClass.setGeoplugin_timezone(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_currencyCode")) {
            myClass.setGeoplugin_currencyCode(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_currencySymbol")) {
            myClass.setGeoplugin_currencySymbol(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_currencySymbol_UTF8")) {
            myClass.setGeoplugin_currencySymbol_UTF8(new String(ch, start, length));
        }
        if (thisElement.equals("geoplugin_currencyConverter")) {
            myClass.setGeoplugin_currencyConverter(new Double(new String(ch, start, length)));
        }

    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
        myClass.setRootElement(rootElement);
    }



}


