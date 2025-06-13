package com.example.customer.repository;

import com.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContaining(String keyword);

    List<Customer> findByRegisteredDateAfter(LocalDate date);

    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> findCustomersByName(String name);
}
