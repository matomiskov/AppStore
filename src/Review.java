import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * App Review
 *
 * AppStore > App > Reviews > Review
 * 
 * @author Miškov, Ďuraš
 */
public class Review {

	// Hodnotenie od 1 do 5 ako cele cislo
    private int rating;

    // Volitelny komentar
    private String comment;

    // Meno autora
    private String author;

    // Datum a cas vytvorenia
    private Date dateTime;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) throws RuntimeException {
    	if (rating < 1 || rating > 5) {
    		throw new RuntimeException("Rating musi byt cele cislo medzi 1 a 5.");
    	}

    	this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) throws DateTimeParseException {
    	this.dateTime = Date.from(OffsetDateTime.parse(dateTime).toInstant());
    }

    public String toString() {
    	String authorName;
    	if (author != null) {
    		authorName = author;
    	} else {
    		authorName = "Anonym";
    	}
    	String review = rating + "/5 stars from " + authorName + " on " + dateTime.toString() + ".";
    	
    	if (comment != null) {
    		review = review + " Comment: \"" + comment + "\"";
    	}
    	
    	return review;
    }
}
