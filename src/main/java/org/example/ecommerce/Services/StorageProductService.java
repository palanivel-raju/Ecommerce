package org.example.ecommerce.Services;

import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Repo.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class StorageProductService implements IProductService{
    private ProductRepo productRepo;
    public StorageProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAllproducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getproductById(Long productId) {
        Optional<Product> product = productRepo.findById(productId);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
