package com.example.productdashboard.controller;

import com.example.productdashboard.entity.Product;
import com.example.productdashboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return service.findByCategory(category);
    }

    @GetMapping("/price")
    public List<Product> getByPriceRange(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return service.findByPriceRange(min, max);
    }

    @GetMapping("/search")
    public List<Product> searchByName(@RequestParam String name) {
        return service.searchByName(name);
    }

    @GetMapping("/search-by-name-category")
    public List<Product> searchByNameAndCategory(@RequestParam String name, @RequestParam String category) {
        return service.searchByNameAndCategory(name, category);
    }
}
