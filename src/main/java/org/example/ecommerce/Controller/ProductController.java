package org.example.ecommerce.Controller;

import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Category;
import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Services.IProductService;
import org.example.ecommerce.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private IProductService iProductService;
    public ProductController(IProductService iProductService){
        this.iProductService = iProductService;
    }


    @GetMapping("/products")
    public List<Product> getAllproducts(){
        return iProductService.getAllproducts();
    }

    @GetMapping("/products/{id}")
    public Product getproductById(@PathVariable("id") Long productId){
        return iProductService.getproductById(productId);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        //productRequestDTO to Product
        Product product = getProductfromProductDTO(productRequestDTO);
        return iProductService.createProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(value = "id")Long productId, @RequestBody ProductRequestDTO productRequestDTO){
        //productRequestDTO to Product
        Product product = getProductfromProductDTO(productRequestDTO);
        return iProductService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable("id") Long productId){
        return iProductService.deleteProduct(productId);
    }
    public Product getProductfromProductDTO(ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product.setId(productRequestDTO.getId());
        product.setName(productRequestDTO.getName());
        product.setDesc(productRequestDTO.getDesc());
        product.setPrice(productRequestDTO.getPrice());
        product.setImageUrl(productRequestDTO.getImageUrl());
        if(productRequestDTO.getCategory()!= null){
            Category category = new Category();
            category.setId(productRequestDTO.getCategory().getId());
            category.setName(productRequestDTO.getCategory().getName());
            product.setCategory(productRequestDTO.getCategory());
        }
        return product;
    }
}
