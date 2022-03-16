package com.springdatajpa3.onetoone.repos;

import com.springdatajpa3.onetoone.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Book, Integer> {

}
