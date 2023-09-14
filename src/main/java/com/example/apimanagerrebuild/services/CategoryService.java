package com.example.apimanagerrebuild.services;


import com.example.apimanagerrebuild.models.Category;
import com.example.apimanagerrebuild.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository catRepo;

    public void addCategory(Category c){
        catRepo.save(c);
    }
}
