import java.util.*;

/**
 * Korenovy element AppStore
 *
 * @author Miškov, Ďuraš
 */
public class AppStore {

    // Zoznam aplikacii
    private final List<App> apps = new ArrayList<App>();

    public List<App> getApps() {
        return apps;
    }

    public void addApp(App newApp) {
    	this.apps.add(newApp);
    }

    // Vytvori novy AppStore
    public AppStore() {
    }

    // Vypise aplikacie
    public void vypis() {
        System.out.println("List of applications in AppStore:");
        for (App app : apps) {
        	System.out.println("-----------------------------");
        	app.vypis();
        }
    }
}
