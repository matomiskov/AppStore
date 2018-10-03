
import java.text.SimpleDateFormat;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author martin
 */
public class Distributable {

    private String file;
    private String version;
    private String arch;
    private String DateTime;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }

    public String toString() {
        SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.GERMANY);
        String date = DateTime.replaceAll("\\+0([0-9]){1}\\:00", "+0$100");
        try {
            ISO8601DATEFORMAT.parse(date);
        } catch (Exception e) {
        }
        return "File: " + file + ". Version: " + version + ". Arch: " + arch + ". DateTime:" + ISO8601DATEFORMAT;
    }

}
