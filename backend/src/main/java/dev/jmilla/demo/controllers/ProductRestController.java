package dev.jmilla.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jmilla.demo.model.entities.Product;
import dev.jmilla.demo.model.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    // @Autowired allows Spring to inject the ProductRepository into this class
    @Autowired
    private ProductRepository repositorio;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        // Fetch product by ID from the database
        Optional<Product> producto = repositorio.findById(id);

        // Return the product if found, or throw an exception (or handle it as needed)
        return producto.orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Allow all origins
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Product> findAll() {
        // Fetch all products from the database
        List<Product> productos = repositorio.findAll();

        // Return the products if found, or throw an exception (or handle it as needed)
        return productos;
    }

}
