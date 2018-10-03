import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Precita a vytvori AppStore z XML
 *
 * @author Miškov, Ďuraš
 */
public class DOMReaderOfAppStore {

    private AppStore createAppStore(Element xmlAppStore) {
        if (!"AppStore".equals(xmlAppStore.getNodeName())) {
            throw new RuntimeException("Nespravny korenovy element.");
        }

        AppStore appStore = new AppStore();

        NodeList xmlApps = xmlAppStore.getChildNodes();
        for (int i = 0; i < xmlApps.getLength(); i++) {
            Node xmlApp = xmlApps.item(i);

            if ((xmlApp instanceof Element)
                    && ("App".equals(xmlApp.getNodeName()))) {
                App newApp = createApp((Element) xmlApp);
                appStore.addApp(newApp);
            }
        }

        return appStore;
    }

    private App createApp(Element xmlApp) throws RuntimeException {
        App app = new App();

        int id;
        try {
        	id = Integer.parseInt(xmlApp.getAttribute("id"));
        } catch (NumberFormatException e) {
        	throw new RuntimeException("ID musi byt cele kladne cislo.");
        }
        app.setId(id);
        
        Element name = vratPodelement(xmlApp, "Name");
        if (name == null) {
        	throw new RuntimeException("Name element je povinny pre App.");
        }
        app.setName(name.getTextContent());

        Element description = vratPodelement(xmlApp, "Description");
        if (description == null) {
        	throw new RuntimeException("Description element je povinny pre App.");
        }
        app.setDescription(description.getTextContent().trim());

        Element category = vratPodelement(xmlApp, "Category");
        if (category != null) {
        	app.setCategory(category.getTextContent());
        }

        Element author = vratPodelement(xmlApp, "Author");
        if (author == null) {
        	throw new RuntimeException("Author element je povinny pre App.");
        }
        app.setAuthor(this.createAuthor(author));

        Element distributables = vratPodelement(xmlApp, "Distributables");
        if (distributables == null) {
        	throw new RuntimeException("Distributables element je povinny pre App.");
        }
        NodeList distributablesList = distributables.getChildNodes();
        for (int i = 0; i < distributablesList.getLength(); i++) {
            Node xmlDistributable = distributablesList.item(i);
            if ((xmlDistributable instanceof Element)
                    && ("Distributable".equals(xmlDistributable.getNodeName()))) {
                app.addDistributable(createDistributable((Element) xmlDistributable));
            }
        }

        Element reviews = vratPodelement(xmlApp, "Reviews");
        if (reviews == null) {
        	throw new RuntimeException("Reviews element je povinny pre App.");
        }
        NodeList reviewsList = reviews.getChildNodes();
        for (int i = 0; i < reviewsList.getLength(); i++) {
            Node xmlReview = reviewsList.item(i);
            if ((xmlReview instanceof Element)
                    && ("Review".equals(xmlReview.getNodeName()))) {
                app.addReview(createReview((Element) xmlReview));
            }
        }
        
        return app;
    }

    private Distributable createDistributable(Element xmlDistributable) {
        Distributable distributable = new Distributable();

        Element file = vratPodelement(xmlDistributable, "File");
        if (file == null) {
        	throw new RuntimeException("File element je povinny pre Distributable.");
        }
        distributable.setFile(file.getTextContent());

        Element version = vratPodelement(xmlDistributable, "Version");
        if (version == null) {
        	throw new RuntimeException("Version element je povinny pre Distributable.");
        }
        distributable.setVersion(version.getTextContent());

        Element arch = vratPodelement(xmlDistributable, "Arch");
        if (arch == null) {
        	throw new RuntimeException("Arch element je povinny pre Distributable.");
        }
        distributable.setArch(arch.getTextContent());

        Element dateTime = vratPodelement(xmlDistributable, "DateTime");
        if (dateTime == null) {
        	throw new RuntimeException("DateTime element je povinny pre Distributable.");
        }
        distributable.setDateTime(dateTime.getTextContent());

        return distributable;
    }

    private Review createReview(Element xmlReview) {
        Review review = new Review();

        Element rating = vratPodelement(xmlReview, "Rating");
        if (rating == null) {
        	throw new RuntimeException("Rating element je povinny pre Review.");
        }
        review.setRating(Integer.parseInt(rating.getTextContent()));

        Element comment = vratPodelement(xmlReview, "Comment");
        if (comment != null) {
            review.setComment(comment.getTextContent());
        }

        Element name = vratPodelement(xmlReview, "Name");
        if (name != null) {
            review.setAuthor(name.getTextContent());
        }

        Element dateTime = vratPodelement(xmlReview, "DateTime");
        if (dateTime == null) {
        	throw new RuntimeException("DateTime element je povinny pre Review.");
        }
        review.setDateTime(dateTime.getTextContent());

        return review;
    }

    private Author createAuthor(Element xmlAuthor) {
        String id = xmlAuthor.getAttribute("id");

        String name = xmlAuthor.getTextContent();
        Author author = new Author(Integer.parseInt(id), name);

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
            throw new RuntimeException("Not possible to read, or parse XML file.", e);
        }
        return createAppStore(doc.getDocumentElement());
    }

    public static void main(String[] args) {
        DOMReaderOfAppStore reader = new DOMReaderOfAppStore();
        AppStore appStore = reader.readFromXML(new File("AppStore.xml"));
        appStore.vypis();
    }
}
