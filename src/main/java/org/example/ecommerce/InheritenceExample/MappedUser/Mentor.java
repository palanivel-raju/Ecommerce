package org.example.ecommerce.InheritenceExample.MappedUser;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "sc_mentor")
@DiscriminatorValue("2")
public class Mentor extends User {
    private int noofhrs;
}
