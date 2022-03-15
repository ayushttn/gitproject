package com.springdatajpa2.repos;

import com.springdatajpa2.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}

