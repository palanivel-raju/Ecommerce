package org.example.ecommerce.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String name;
    private String desc;
    private String imageUrl;
    private String spec;
    private Double price;
    private Category category;
}
