package org.example.ecommerce.InheritenceExample.MappedUser;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "sc_TA")
@DiscriminatorValue("1")
public class TA extends User {
    private int nofrating;
}
