package org.example.ecommerce.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
public class ProductControllerMVC {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService iProductService;

    @Autowired
    private ObjectMapper objectMapper;

    //without product created can try means different error
    @Test
    public void Test_GetAllProducts_RunSucessfully() throws Exception{
        List<Product> productList = new ArrayList<>();
        Product product = new Product();
        product.setName("trimmer");
        productList.add(product);
        Product product2 = new Product();
        product2.setName("samsung");
        productList.add(product2);
        when(iProductService.getAllproducts()).thenReturn(productList);

        //Act
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                //.andExpect(content().contentType("[]"))// will give invalid media type, "no string coverted"
        //object -> json -> string
                .andExpect(content().string(objectMapper.writeValueAsString(productList)))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("trimmer"))//checking the value with obj mapping
                .andExpect(jsonPath("$[1].name").value("samsung"));
    }
    @Test
    public void Test_CreateProduct_CreatedSuccessfully() throws Exception{
        //Arrange
        Product expectedProduct = new Product();
        expectedProduct.setId(2L);
        expectedProduct.setName("RoyalEnfield");
        expectedProduct.setPrice(100000D);

        ProductRequestDTO productToCreate = new ProductRequestDTO();
        productToCreate.setId(2L);
        productToCreate.setName("RoyalEnfield");
        productToCreate.setPrice(100000D);

        //ACT // &+^^^^^^ you are passing dto in controller -> that converted product only but
        //here whatever u pass u wanna default one expected thats u this right?
        when(iProductService.createProduct(any(Product.class))).thenReturn(expectedProduct);

        mockMvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(productToCreate)))
                .andExpect(content().string(objectMapper.writeValueAsString(expectedProduct)))
                .andExpect(status().isOk());

    }


}
