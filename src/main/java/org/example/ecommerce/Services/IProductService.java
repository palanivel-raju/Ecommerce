package org.example.ecommerce.Services;

import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllproducts();

    Product getproductById(Long productId);

    Product createProduct(Product product);

    Product updateProduct(Long productId, Product product);

    Product deleteProduct(Long productId);
}
