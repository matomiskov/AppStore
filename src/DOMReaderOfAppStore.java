
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author martin
 */
public class DOMReaderOfAppStore {

    private AppStore createAppStore(Element xmlAppStore) {
        if (!"AppStore".equals(xmlAppStore.getNodeName())) {
            throw new RuntimeException("Nespravny korenovy element");
        }

        AppStore appStore = new AppStore();

        NodeList xmlApps = xmlAppStore.getChildNodes();
        for (int i = 0; i < xmlApps.getLength(); i++) {

            Node xmlApp = xmlApps.item(i);

            if ((xmlApp instanceof Element)
                    && ("App".equals(xmlApp.getNodeName()))) {
                App newApp = createApp((Element) xmlApp);
                appStore.getApps().add(newApp);
            }
        }
        return appStore;
    }

    private App createApp(Element xmlApp) {

        App app = new App();
        String id = xmlApp.getAttribute("id");

        Element name = vratPodelement(xmlApp, "Name");
        app.setName(name.getTextContent());

        Element description = vratPodelement(xmlApp, "Description");
        app.setDescription(description.getTextContent());

        Element category = vratPodelement(xmlApp, "Category");
        app.setCategory(category.getTextContent());

        /*
        
        Tu to nemam teraz dokocene... 
        Treba tu spravit este k autorovi xmlAuthor
        A doplnit cele metody createReview a create Distributable
        
        */
        Element author = vratPodelement(xmlApp, "Author");

        return app;
    }

    private Author createAuthor(Element xmlAuthor) {

        String id = xmlAuthor.getAttribute("id");
        String name = xmlAuthor.getAttribute("Author");
        Author author = new Author(id, name);

        return author;
    }

    private Element vratPodelement(Element xmlElement, String nazovElementu) {
        NodeList xmlDeti = xmlElement.getChildNodes();
        for (int i = 0; i < xmlDeti.getLength(); i++) {
            Node xmlDieta = xmlDeti.item(i);
            if ((xmlDieta instanceof Element)
                    && (nazovElementu.equals(xmlDieta.getNodeName()))) {
                return (Element) xmlDieta;
            }
        }

        return null;
    }

    public AppStore readFromXML(File xmlSubor) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder parser;
        try {
            parser = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Cannot create parser.", e);
        }
        Document doc;
        try {
            doc = parser.parse(xmlSubor);
        } catch (Exception e) {
            throw new RuntimeException("Not possible read, or parse XML file.", e);
        }
        return createAppStore(doc.getDocumentElement());
    }

    public static void main(String[] args) {
        DOMReaderOfAppStore reader = new DOMReaderOfAppStore();
        AppStore appStore = reader.readFromXML(new File("AppStore.xml"));
        appStore.vypis();
    }
}
