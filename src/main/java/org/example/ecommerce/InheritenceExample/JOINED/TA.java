package org.example.ecommerce.InheritenceExample.JOINED;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "join_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private int nofrating;
}
