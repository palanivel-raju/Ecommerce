package org.example.ecommerce.Repository;

import jakarta.transaction.Transactional;
import org.example.ecommerce.Models.Category;
import org.example.ecommerce.Repo.CategoryRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;
    @Test
    @Transactional
    void testLoading(){
        Category c = categoryRepo.findById(2L).get();
        System.out.println(c.getName());
        System.out.println("debug");
    }


}
