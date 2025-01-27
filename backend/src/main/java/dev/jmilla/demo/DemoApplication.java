package dev.jmilla.demo;

// import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;

// import dev.jmilla.demo.model.entities.Product;
// import dev.jmilla.demo.model.repositories.ProductRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);

		// ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// ProductRepository repository = context.getBean(ProductRepository.class);

		// List<Product> products = List.of(
		// 	new Product(null, "iPhone", 999.99, 10),
		// 	new Product(null, "MacBook Pro", 1999.99, 5),
		// 	new Product(null, "Apple Watch", 699.99, 1),
		// 	new Product(null, "iPad", 499.99, 20)
		// );
		
		// repository.saveAll(products);

	}

}
