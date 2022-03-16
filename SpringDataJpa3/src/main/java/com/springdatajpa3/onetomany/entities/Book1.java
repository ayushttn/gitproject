package com.springdatajpa3.onetomany.entities;


import javax.persistence.*;

@Entity
@Table(name = "books1")
public class Book1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author1 author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author1 getAuthor() {
        return author;
    }

    public void setAuthor(Author1 author) {
        this.author = author;
    }
}
