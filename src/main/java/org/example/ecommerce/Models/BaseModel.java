package org.example.ecommerce.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;
    private Date createdAt;
    private Date modifiedAt;
    private Status status;
}
