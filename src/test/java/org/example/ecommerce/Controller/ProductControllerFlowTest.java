package org.example.ecommerce.Controller;

import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductControllerFlowTest {
    @Autowired
    ProductController productController;
    @Test
    public void Test_create_update_remove_ReadSuccesfully(){
        //Arrange
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setId(2L);
        productDTO.setName("orange Laptop");
        //create  //&*&&&&& conversion is required any bean or actual class?
        Product newProduct = productController.createProduct(productDTO);
        ResponseEntity<Product> getCreatedProduct = productController.getproductById(newProduct.getId());

        //update
        productDTO.setName("green laptop");
        Product updateProduct = productController.updateProduct(productDTO.getId(),productDTO);
        ResponseEntity<Product> getupdateProduct = productController.getproductById(updateProduct.getId());

//        //RemoveProduct
//        Product deleteProduct = productController.deleteProduct(productDTO.getId());
//        ResponseEntity<Product> getdeletedProduct = productController.getproductById(deleteProduct.getId());

        assertEquals("orange Laptop", getCreatedProduct.getBody().getName());
        assertEquals("green laptop", getupdateProduct.getBody().getName());
    }
}
