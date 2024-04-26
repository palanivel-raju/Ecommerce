package org.example.ecommerce.Repo;

import org.example.ecommerce.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);

}
