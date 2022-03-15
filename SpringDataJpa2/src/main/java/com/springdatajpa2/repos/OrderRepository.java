package com.springdatajpa2.repos;

import com.springdatajpa2.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
