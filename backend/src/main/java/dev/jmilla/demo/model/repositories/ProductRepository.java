package dev.jmilla.demo.model.repositories;

import dev.jmilla.demo.model.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find all with price greater than 900
    List<Product> findByPriceGreaterThan(double price);

}
