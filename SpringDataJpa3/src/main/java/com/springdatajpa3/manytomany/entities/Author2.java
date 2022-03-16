package com.springdatajpa3.manytomany.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author2")
public class Author2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  name;
    @Embedded
    private Address2 address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"
            , referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"
            , referencedColumnName = "id"))
    private Set<Book2> books;

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

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }

    public Set<Book2> getBooks() {
        return books;
    }

    public void setBooks(Set<Book2> books) {
        this.books = books;
    }


}
