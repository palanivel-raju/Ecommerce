package org.example.ecommerce.InheritenceExample.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "singletable_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private int noofhrs;
}
