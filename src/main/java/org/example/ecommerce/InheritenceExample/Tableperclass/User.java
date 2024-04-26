package org.example.ecommerce.InheritenceExample.Tableperclass;

import jakarta.persistence.*;

//Approach 1 each having different table
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
