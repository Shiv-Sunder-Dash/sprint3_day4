package com.example.customerapi.repository;

import com.example.customerapi.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindByEmailContaining() {
        Customer customer = new Customer("Alice", "alice@example.com", LocalDate.now());
        customerRepository.save(customer);

        List<Customer> results = customerRepository.findByEmailContaining("alice");
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getEmail()).isEqualTo("alice@example.com");
    }

    @Test
    void testFindByRegisteredDateAfter() {
        Customer oldCustomer = new Customer("Bob", "bob@example.com", LocalDate.of(2020, 1, 1));
        Customer newCustomer = new Customer("Charlie", "charlie@example.com", LocalDate.of(2023, 1, 1));
        customerRepository.save(oldCustomer);
        customerRepository.save(newCustomer);

        List<Customer> results = customerRepository.findByRegisteredDateAfter(LocalDate.of(2022, 1, 1));
        assertThat(results).extracting(Customer::getName).containsExactly("Charlie");
    }

    @Test
    void testFindCustomersByName() {
        Customer customer = new Customer("David", "david@example.com", LocalDate.now());
        customerRepository.save(customer);

        List<Customer> results = customerRepository.findCustomersByName("David");
        assertThat(results).isNotEmpty();
    }
}
