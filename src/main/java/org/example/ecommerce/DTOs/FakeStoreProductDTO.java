package org.example.ecommerce.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.example.ecommerce.Models.Category;

@Getter
@Setter
public class FakeStoreProductDTO{
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
