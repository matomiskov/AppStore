/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 */
public class Author {

    private String authorID;
    private String author;

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Author(String authorID, String author) {
        this.authorID = authorID;
        this.author = author;
    }

    public String toString() {
        return "Author: " + author + ", ID: " + authorID + ".";
    }
}
