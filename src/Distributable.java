import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * App Distributable
 *
 * AppStore > App > Distributables > Distributable
 *
 * @author Miškov, Ďuraš
 */
public class Distributable {

	// Meno suboru, vratane pripony
    private String file;

    // Verzia, ktora nesleduje semver specifikaciu
    private String version;

    // Architektura na ktoru je buildnuta, moze byt 'arm', 'arm64' alebo 'x86'
    private String arch;

    // Datum a cas vytvorenia
    private Date dateTime;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) throws RuntimeException {
    	// Nasleduje to semver specifikaciu?
    	boolean semverMatch = version.matches(
    		"^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$"
    	);

    	if (!semverMatch) {
    		throw new RuntimeException("Verzia Distributable nenasleduje semver specifikaciu.");
    	}
    	
    	this.version = version;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) throws RuntimeException {
    	if (!(arch.equals("arm") || arch.equals("arm64") || arch.equals("x86"))) {
    		throw new RuntimeException("Architektura Distributable moze byt len 'arm', 'arm64' alebo 'x86'.");
    	}

    	this.arch = arch;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) throws DateTimeParseException {
    	this.dateTime = Date.from(OffsetDateTime.parse(dateTime).toInstant());
    }

    public String toString() {
        return "Distributable: " + file + " v" + version + " (arch: " + arch + ") created " + dateTime.toString();
    }

}
