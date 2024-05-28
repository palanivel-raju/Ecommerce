package org.example.ecommerce.Repo;

import org.example.ecommerce.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductRepo extends JpaRepository<Product, Long> {


     Product save(Product product);

//     @Query("select name from Product where id =?1")
//    String getProductNameById(long l);

    @Query("select name from Product where id =:id1")
    String getProductNameById(@Param("id1") long l);

    @Query("select c.name from Product p join Category c ON p.category.id = c.id and p.id =?1")
    String getCategoryNameFromProductId(long l);
}
