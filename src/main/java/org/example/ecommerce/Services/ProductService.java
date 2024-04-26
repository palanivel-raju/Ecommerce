package org.example.ecommerce.Services;

import org.example.ecommerce.Clients.fakeApiStore.FakeStoreApiClient;
import org.example.ecommerce.DTOs.FakeStoreProductDTO;
import org.example.ecommerce.DTOs.ProductRequestDTO;
import org.example.ecommerce.Models.Category;
import org.example.ecommerce.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    RestTemplateBuilder restTemplateBuilder;
    FakeStoreApiClient fakeStoreApiClient;
    public ProductService(RestTemplateBuilder restTemplateBuilder, FakeStoreApiClient fakeStoreApiClient){
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreApiClient = fakeStoreApiClient;
    }

    @Override
    public List<Product> getAllproducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDTO[].class).getBody();
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            products.add(getProduct(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product getproductById(Long productId){
        if(productId <= 0){
            throw new IllegalArgumentException("Invalid id passed, please try with other Id");
        }
       return getProduct(fakeStoreApiClient.getproductById(productId));
    }

    @Override
    public Product createProduct(Product product){
      return getProduct(fakeStoreApiClient.createProduct(product));
    }

    @Override
    public Product updateProduct(Long productId, Product product){
       return getProduct(fakeStoreApiClient.updateProduct(productId,product));
    }

    @Override
    public Product deleteProduct(Long productId){
        return getProduct(fakeStoreApiClient.deleteProduct(productId));
    }

    private Product getProduct(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setName(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImageUrl(fakeStoreProductDTO.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }
}
