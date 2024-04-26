package org.example.ecommerce.InheritenceExample.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_ta")
public class TA extends User {
    private int nofrating;
}
