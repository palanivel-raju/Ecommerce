package org.example.ecommerce.InheritenceExample.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Singletable_Instructor")
@DiscriminatorValue("3")
public class Instructor extends User{
    private String company;
}
