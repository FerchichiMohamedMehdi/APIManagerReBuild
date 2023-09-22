package com.example.apimanagerrebuild.repositories;

import com.example.apimanagerrebuild.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    void deleteById(Long id);

}
