package com.springdatajpa3;

import com.springdatajpa3.manytomany.entities.Address2;
import com.springdatajpa3.manytomany.entities.Author2;
import com.springdatajpa3.manytomany.entities.Book2;
import com.springdatajpa3.manytomany.repos.Author2Repo;
import com.springdatajpa3.onetomany.entities.Address1;
import com.springdatajpa3.onetomany.entities.Author1;
import com.springdatajpa3.onetomany.entities.Book1;
import com.springdatajpa3.onetomany.repos.AuthorRepo;
import com.springdatajpa3.onetoone.entities.Address;
import com.springdatajpa3.onetoone.entities.Author;
import com.springdatajpa3.onetoone.entities.Book;
import com.springdatajpa3.onetoone.repos.BooksRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class SpringDataJpa3ApplicationTests {
    //ONETOONEMAPPING

    @Autowired
    BooksRepo booksRepo;

    @Test
    public void testCreateAuthorOneToOne(){
        Author author = new Author();
        author.setName("Doraemon");

        Address address = new Address();
        address.setStreetNumber("119");
        address.setLocation("Burari");
        address.setState("Delhi");
        author.setAddress(address);

        Book book = new Book();
        book.setBookName("Disney");
        book.setAuthor(author);

        booksRepo.save(book);
    }

    //ONETOMANY

    @Autowired
    AuthorRepo authorRepo;

    @Test
    void testCreateAuthorOneToMany() {
        Author1 author = new Author1();
        author.setName("Nobita");

        Address1 address = new Address1();
        address.setStreetNumber("119");
        address.setLocation("Burari");
        address.setState("Delho");
        author.setAddress(address);

        Set<Book1> books = new HashSet<>();
        Book1 book = new Book1();
        book.setBookName("Disney");
        book.setAuthor(author);

        books.add(book);

        Book1 book1 = new Book1();
        book1.setBookName("Nicklodean");
        book1.setAuthor(author);

        books.add(book1);
        author.setBooks(books);

        authorRepo.save(author);
    }

    //MANYTOMANY

    @Autowired
    Author2Repo author2Repo;

    @Test
    public void testmanyToManyCreateProgrammer(){
        Author2 author = new Author2();
        author.setName("shinchan");

        Address2 address = new Address2();
        address.setStreetNumber("119");
        address.setLocation("Burari");
        address.setState("Delhi");
        author.setAddress(address);

        HashSet<Book2> books = new HashSet<Book2>();
        Book2 book = new Book2();
        book.setBookName("Shining");
        books.add(book);
        author.setBooks(books);
        author2Repo.save(author);
    }

}
