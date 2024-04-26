package org.example.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel{
    private String name;
    private String description;
    private String imageUrl;
    private String spec;
    private Double price;

//    @JoinColumn(name ="category_id")
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Category category;
}
