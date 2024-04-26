package org.example.ecommerce.InheritenceExample.Singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "singletable_TA")
@DiscriminatorValue("1")
public class TA extends User {
    private int nofrating;
}
