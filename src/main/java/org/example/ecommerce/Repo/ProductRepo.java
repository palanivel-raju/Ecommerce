package org.example.ecommerce.Repo;

import org.example.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {


     Product save(Product product);
}
