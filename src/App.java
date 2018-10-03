import java.util.*;

/**
 * Aplikacia v zozname aplikacii
 *
 * AppStore > App
 *
 * @author Miškov, Ďuraš
 */
public class App {

    // Id aplikacie
    private int id;

    // Nazov aplikacie
    private String name;

    // Popis aplikacie, moze obsahovat HTML
    private String description;

    // Meno autora aplikacie
    private Author author;

    // Volitelna kategoria
    private String category;

    // Zoznam distribuovatelnych suborov
    private final List<Distributable> distributables = new ArrayList<Distributable>();

    // Zoznam hodnoteni
    private final List<Review> reviews = new ArrayList<Review>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Distributable> getDistributables() {
        return distributables;
    }

    public void addDistributable(Distributable newDist) {
    	this.distributables.add(newDist);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review newReview) {
    	this.reviews.add(newReview);
    }

    public void vypis() {
        System.out.print(this.name + " (ID: " + this.id + ") by " + author.toString() + ".");

        if (this.category != null) {
        	System.out.println(" Category: " + category + ".");
        } else {
        	System.out.println(" Uncategorized.");
        }
        System.out.println("Description: " + description);

        for (Distributable distributable : distributables) {
        	System.out.println(distributable.toString());
        }
        System.out.println();

        for (Review review : reviews) {
            System.out.println(review.toString());
        }
        System.out.println();
    }
}
