package org.example.ecommerce.Controller;

import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Category;
import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Services.IProductService;
import org.example.ecommerce.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<Product> getproductById(@PathVariable("id") Long productId){
//        MultiValueMap<String , String> headers = new LinkedMultiValueMap<>();
//        headers.add("header1", " added manually");
//        try{
//            headers.add("header2", " added manually in try block");
//            if(productId <= 0){
//                throw new IllegalArgumentException("Invalid product Id");
//            }
//            Product product = iProductService.getproductById(productId);
//            return new ResponseEntity<>(product, headers, HttpStatus.ACCEPTED);
//        }
//        catch(Exception e){
//            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
//        }

        //other way for handling exception by controller advice
        Product product = iProductService.getproductById(productId);
        return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
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
//        product.setId(productRequestDTO.getId());
        product.setName(productRequestDTO.getName());
        product.setDescription(productRequestDTO.getDescription());
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
