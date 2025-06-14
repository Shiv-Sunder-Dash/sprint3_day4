package com.example.productdashboard.repository;

import com.example.productdashboard.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository repository;

    @Test
    void testFindByCategory() {
        Product p = new Product();
        p.setName("TestProduct");
        p.setPrice(BigDecimal.valueOf(100));
        p.setCategory("Electronics");
        repository.save(p);
        List<Product> result = repository.findByCategory("Electronics");
        assertFalse(result.isEmpty());
    }
}
