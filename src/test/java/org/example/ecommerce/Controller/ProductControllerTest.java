package org.example.ecommerce.Controller;

import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Services.IProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {
    //Arrange
    @Autowired
    ProductController productController;

    @MockBean
    IProductService iProductService;
    @Captor
    ArgumentCaptor<Long> idcaptor;

    @Test
    void getAllproducts() {
    }

    @Test
    @DisplayName("Product fetched Succesfully - happy path")
    void Test_Getproduct_withValidId_ReturnProductSucessfully() {

        //method 1 add without product
//        //Arrange
//        when(iProductService.getproductById(any(Long.class))).thenReturn(new Product());
//        //Act
//        ResponseEntity<Product> product = productController.getproductById(1L);
//
//        //Assert
//        assertNotNull(product);

        //approach 2 with hard code created product
    //        Arrange
        Product product = new Product();
        product.setId(1L);
        product.setName("macbook air");
        product.setPrice(1000D);
        when(iProductService.getproductById(any(Long.class))).thenReturn(product);
        //Act
        ResponseEntity<Product> responseProduct = productController.getproductById(1L);

        //Assert
        assertNotNull(responseProduct.getBody());
        assertEquals(1000D, responseProduct.getBody().getPrice());
        assertEquals("macbook air", responseProduct.getBody().getName());

    }
    @Test
    @DisplayName("runtime exception from mocked dependency - sad path")
    void Test_GetProduct_ExternalDependencyThrowsException(){

        //Arrange // this area above already tested so why need to test again
        when(iProductService.getproductById(any(Long.class))).thenThrow(new RuntimeException("id hit the service"));

        //Act
        assertThrows(RuntimeException.class, () -> iProductService.getproductById(1L));
        verify(iProductService, times(1)).getproductById(1L);
    }
    @Test
    @DisplayName("Illgel args when product id 0 was passed")
    public void Test_GetProduct_WithInvalidId_ThrowsIllegalArgumentException() {
        //Act and Assert
        assertThrows(IllegalArgumentException.class,
                ()-> productController.getproductById(0L));
        verify(iProductService, times(0)).getproductById(1L);//why with 1 is not working here
    }

    @Test
    @DisplayName("Product service called with the expected argument - happy path")
    void Test_Id_captured_value_correct() {
        //Arrange
        Long id = 2L;

        //Act
        productController.getproductById(id);
        verify(iProductService).getproductById(idcaptor.capture());
        assertEquals(id, idcaptor.getValue());
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getProductfromProductDTO() {
    }
}