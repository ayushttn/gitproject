package com.springdatajpa2.repos;

import com.springdatajpa2.entities.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Integer> {
}
