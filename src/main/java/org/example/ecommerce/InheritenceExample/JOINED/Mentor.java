package org.example.ecommerce.InheritenceExample.JOINED;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "join_mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private int noofhrs;
}
