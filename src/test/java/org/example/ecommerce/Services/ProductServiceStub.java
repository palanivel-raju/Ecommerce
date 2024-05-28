package org.example.ecommerce.Services;

import org.example.ecommerce.Models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productservicestub")
public class ProductServiceStub implements IProductService{
    Map<Long, Product> products;

    public ProductServiceStub(){
        products = new HashMap<>();
    }

    @Override
    public List<Product> getAllproducts() {
        return (List) products.values();
    }

    @Override
    public Product getproductById(Long productId) {
        if(products.containsKey(productId)){
            return products.get(productId);
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
         products.put(product.getId(), product);
         return products.get(product.getId());
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return products.put(product.getId(), product);
    }

    @Override
    public Product deleteProduct(Long productId) {
        return products.remove(productId);
    }
}
