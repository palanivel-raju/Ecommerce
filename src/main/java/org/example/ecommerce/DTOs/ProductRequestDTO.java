package org.example.ecommerce.DTOs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.ecommerce.Models.Category;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDTO {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String spec;
    private Double price;
    private Category category;
}
