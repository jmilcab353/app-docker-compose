package dev.jmilla.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

import dev.jmilla.demo.model.entities.Product;
import dev.jmilla.demo.model.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Product> products = repository.findAll();
        // Al tener los productos en una List, puedo meterlos en un stream y hacer un map o un filter
        model.addAttribute("products", products);


        List<Product> expensiveProducts = repository.findByPriceGreaterThan(900);
        model.addAttribute("expensiveProducts", expensiveProducts);
        

        // Le pasamos el contenido a la vista
        model.addAttribute("content", "product/list");

        return "layout";
    }

    @GetMapping("new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("content", "product/new");
        return "layout";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute Product product) {
        repository.save(product);
        return "redirect:/products";
    }

    // Edit
    @GetMapping("/{id}/edit")
    public String editProductForm(@PathVariable Long id, Model model) {
        repository.findById(id).ifPresentOrElse(
                product -> {
                    model.addAttribute("product", product);
                    model.addAttribute("content", "product/edit");
                },
                () -> {
                    throw new IllegalArgumentException("Product not found");
                });
        return "layout";
    }

    @PostMapping("/{id}/edit")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id); // Ensure the ID is correctly set
        repository.save(product);
        return "redirect:/products";
    }

    // View details
    @GetMapping("/{id}/view")
    public String viewProductDetails(@PathVariable Long id, Model model) {
        repository.findById(id).ifPresentOrElse(
                product -> {
                    model.addAttribute("product", product);
                    model.addAttribute("content", "product/view");
                },
                () -> {
                    throw new IllegalArgumentException("Product not found");
                });
        return "layout";
    }

    // Delete
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long id) {
        repository.findById(id).ifPresentOrElse(
                product -> repository.delete(product),
                () -> {
                    throw new IllegalArgumentException("Product not found");
                });
        return "redirect:/products";
    }

}
