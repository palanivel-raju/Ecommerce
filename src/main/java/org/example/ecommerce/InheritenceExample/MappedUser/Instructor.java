package org.example.ecommerce.InheritenceExample.MappedUser;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "sc_Instructor")
public class Instructor extends User {
    private String company;
}
