package com.springdatajpa3.manytomany.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books2")
public class Book2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    @ManyToMany(mappedBy = "books")
    private Set<Author2> authors;

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

    public Set<Author2> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author2> authors) {
        this.authors = authors;
    }


}