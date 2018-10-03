
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Review {

    private int rating;
    private String comment;
    private String name;
    private String dateTime;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String toString() {
        SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.GERMANY);
        String date = dateTime.replaceAll("\\+0([0-9]){1}\\:00", "+0$100");
        Date d = new Date();
        try {
            d = ISO8601DATEFORMAT.parse(date);
        } catch (Exception e) {
        }
        return "Rating: " + rating + ". Comment: " + comment + ". Name: " + name + ". DateTime: " + d;
    }
}
