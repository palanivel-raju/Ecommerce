package org.example.ecommerce.InheritenceExample.JOINED;

import jakarta.persistence.*;

//Approach 1 each having different table
@Entity(name = "join_user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String email;
}
