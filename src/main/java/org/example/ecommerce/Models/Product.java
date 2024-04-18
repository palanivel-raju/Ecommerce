package org.example.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel{
    private String name;
    private String desc;
    private String imageUrl;
    private String spec;
    private Double price;
    private Category category;
}
