package org.example.ecommerce.Controller;

import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @GetMapping("/products")
    public String getAllproducts(){
        return "All products";
    }
    @GetMapping("/products/{id}")
    public Product getproductById(@PathVariable("id") Long productId){
        Product product = new Product();
        product.setId(productId);
        product.setName("knife");
        product.setPrice(504.0);
        return product;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setDesc(productRequestDTO.getDesc());
        return product;
    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(value ="id") @RequestBody ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setDesc(productRequestDTO.getDesc());
        return product;
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){

    }

}
