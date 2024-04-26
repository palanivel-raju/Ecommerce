package org.example.ecommerce.InheritenceExample.MappedUser;

import jakarta.persistence.*;

/*Approach 4 mapped super class parent table will not generate only child class
inherits the parent attributes and create a table
no need @Inheritance, @Entity,
abstract added*/
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
