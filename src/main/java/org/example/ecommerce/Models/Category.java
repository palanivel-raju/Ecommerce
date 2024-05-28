package org.example.ecommerce.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;

    //mappedBy , because we want JPA to consider this relation once only
    @JsonBackReference
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size = 3)
    private List<Product> products;
}
