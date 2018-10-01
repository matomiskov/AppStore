
import java.util.*;

/**
 *
 * @author martin
 */
//aplikacia v zozname aplikacii
public class App {

    //id aplikacie
    private int id;

    //nazov aplikacie
    private String name;

    //popis aplikacie
    private String description;

    //autor aplikacie
    private Author author;

    //kategoria
    private String category;

    //zoznam distribucii
    private final List<Distributable> distributables = new ArrayList<Distributable>();

    //zoznam hodnoteni
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

    public void setAutor(Author author) {
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

    public List<Review> getReviews() {
        return reviews;
    }

    public void vypis() {
        System.out.println(name + ". App ID: " + id + ". Category: " + category + ". " + author.toString());
        System.out.println("Description: " + description);

        if (!distributables.isEmpty()) {
            for (Distributable distributable : distributables) {
                System.out.println(distributable.toString());
            }
        }
        System.out.println();
        if (!reviews.isEmpty()) {
            for (Review review : reviews) {
                System.out.println(review.toString());
            }
        }
        System.out.println();
    }
}
