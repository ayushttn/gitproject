package com.springdatajpa3.onetomany.repos;

import com.springdatajpa3.onetomany.entities.Author1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author1, Integer> {
}
