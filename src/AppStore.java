
import java.util.*;

/**
 *
 * @author martin
 */
// AppStore
public class AppStore {

    //zoznam aplikacii
    private final List<App> apps = new ArrayList<App>();

    public List<App> getApps() {
        return apps;
    }

    //vytvori novy AppStore
    public AppStore() {
    }

    //vypise aplikacie
    public void vypis() {
        System.out.println("List of applications in AppStore:");
        for (App app : apps) {
            app.vypis();
        }
    }
}
