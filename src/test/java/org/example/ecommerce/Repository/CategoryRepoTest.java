package org.example.ecommerce.Repository;

import jakarta.transaction.Transactional;
import org.example.ecommerce.Models.Category;
import org.example.ecommerce.Models.Product;
import org.example.ecommerce.Repo.CategoryRepo;
import org.example.ecommerce.Repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Test
    @Transactional
    void testLoading(){
        Category c = categoryRepo.findById(2L).get();
        System.out.println(c.getName());
        System.out.println("debug");
    }


    @Test
    @Transactional
    @Rollback(value = false)
    public void testFetchMode(){
        Category c = categoryRepo.findById(2L).get();
//        List<Product> products = c.getProducts();
//        for(Product product : products){
//            System.out.println(product.getName());
//        }
    }

    //n+1 queries for select, as we select subselect snaphot takes memory, so loading time is high
    //use select will run n no of queries
    //so using batch size to execute queries in a batch
    @Test
    @Transactional
    @Rollback(value = true)
    public void testgetAllCats(){
        List<Category> categories = categoryRepo.findAll();
        for(Category category : categories){
//            System.out.println("category Id : " + category.getId() + "catogoryname : "+  category.getName());
            List<Product> products = category.getProducts();
            if(products != null && products.get(0) != null){
                System.out.println(products.get(0).getName());
            }
        }
    }
    @Test
    public void testCustom(){
//        String name = productRepo.getProductNameById(2L);
        String c_name = productRepo.getCategoryNameFromProductId(2L);
        System.out.println("debug");
    }



}
