package org.example.ecommerce.InheritenceExample.Tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_mentor")
public class Mentor extends User{
    private int noofhrs;
}
