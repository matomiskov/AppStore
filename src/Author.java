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

    private int authorID;
    private String author;

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Author(int authorID, String author) {
        this.authorID = authorID;
        this.author = author;
    }

    public String toString() {
        return "Author: " + author + ", ID: " + authorID + ".";
    }
}
