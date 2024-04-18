package org.example.ecommerce.DTOs;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.ecommerce.Models.Category;

@Getter
@Setter
public class ProductRequestDTO {
    private Long id;
    private String name;
    private String desc;
    private String imageUrl;
    private String spec;
    private Double price;
    private Category category;
}
