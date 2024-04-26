package org.example.ecommerce.Clients.fakeApiStore;

import org.example.ecommerce.Common.CustomRestTemplate;
import org.example.ecommerce.DTOs.FakeStoreProductDTO;
import org.example.ecommerce.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreApiClient {
    RestTemplateBuilder restTemplateBuilder;
    CustomRestTemplate customRestTemplate;
    public FakeStoreApiClient(RestTemplateBuilder restTemplateBuilder, CustomRestTemplate customRestTemplate){
        this.restTemplateBuilder = restTemplateBuilder;
        this.customRestTemplate = customRestTemplate;
    }
    public FakeStoreProductDTO getproductById(Long productId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDTO.class, productId).getBody();
        return fakeStoreProductDTO;
    }
    public FakeStoreProductDTO createProduct(Product product){
        //product to fakestoreDto as request body of fakestoreapi
        FakeStoreProductDTO fakeStoreProduct = getfakeStoreProduct(product);
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDTO fakeStoreProductDTO= restTemplate.postForEntity("https://fakestoreapi.com/products", fakeStoreProduct, FakeStoreProductDTO.class).getBody();
        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTO updateProduct(Long productId, Product product){
        //product to fakestoreDto as request body of fakestoreapi
        FakeStoreProductDTO fakeStoreProduct = getfakeStoreProduct(product);
        FakeStoreProductDTO fakeStoreProductDTO= customRestTemplate.putForEntity("https://fakestoreapi.com/products/{id}", fakeStoreProduct, FakeStoreProductDTO.class, productId).getBody();
        return fakeStoreProductDTO;
    }

    public FakeStoreProductDTO deleteProduct(Long productId){
        FakeStoreProductDTO fakeStoreProductDTO = customRestTemplate.deleteForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDTO.class, productId).getBody();
        return fakeStoreProductDTO;
    }

    private FakeStoreProductDTO getfakeStoreProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getName());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setImage(product.getImageUrl());
        fakeStoreProductDTO.setPrice(product.getPrice());
        if(product.getCategory()!= null){
            fakeStoreProductDTO.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDTO;
    }
}
