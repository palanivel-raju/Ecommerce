package org.example.ecommerce.InheritenceExample.Singletable;

import jakarta.persistence.*;

//Approach 3 each single table has all the attributes, easy to get the record
//also it's a default method
//how we know which user so enum right? discriminator coloumn for enum type
@Entity(name = "singletable_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
