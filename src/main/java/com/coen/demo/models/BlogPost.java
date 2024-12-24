package com.coen.demo.models;


import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Table(name = "Blogs")
@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column
    private String body;

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn( name = "authorId")
    private Author authorId;

}
