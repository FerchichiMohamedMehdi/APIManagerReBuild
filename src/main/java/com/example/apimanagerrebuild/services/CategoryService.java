package com.example.apimanagerrebuild.services;


import com.example.apimanagerrebuild.models.Category;
import com.example.apimanagerrebuild.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired CategoryRepository catRepo;

    public void addOrUpdateCategory(Category c)
    {
        catRepo.save(c);
    }

    public void deleteCategory(Long idCat){
        catRepo.deleteById(idCat);
    }

    public Category findById(Long id){
        return catRepo.findById(id).get();
    }


    public List<Category> listAll(){
        List listCat = new ArrayList<Category>();
        listCat=catRepo.findAll();
        return listCat;
    }

    /*public void updateCat(Category c){
        Category catUpdated = new Category(c.getIdCategory(), c.getDescription(), c.getNameCategory(), c.getListApi());
        catRepo.save(c);
    }*/

}
