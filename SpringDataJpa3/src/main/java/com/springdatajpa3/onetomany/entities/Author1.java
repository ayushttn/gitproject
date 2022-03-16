package com.springdatajpa3.onetomany.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author1")
public class Author1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  name;
    @Embedded
    private Address1 address;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<Book1> books;

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

    public Address1 getAddress() {
        return address;
    }

    public void setAddress(Address1 address) {
        this.address = address;
    }

    public Set<Book1> getBooks() {
        return books;
    }

    public void setBooks(Set<Book1> books) {
        this.books = books;
    }
}