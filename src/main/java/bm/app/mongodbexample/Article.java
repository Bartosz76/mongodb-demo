package bm.app.mongodbexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @Document informs me this is an element that's going to have a representation in a MongoDB database. This
 * annotation is optional and not necessary.
 */
@Document
public class Article {

    /**
     * In MongoDB's case, the ID is a String. It's a hashcode that's automatically assigned by MongoDB. I am
     * not the one who manages it.
     */
    @Id
    private String id;

    private String author;

    private String title;

    private List<Comment> commentList;

    /**
     * Getters and Setters are required for the usage of the repository.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
