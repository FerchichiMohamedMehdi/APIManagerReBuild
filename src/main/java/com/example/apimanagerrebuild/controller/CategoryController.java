package com.example.apimanagerrebuild.controller;

import com.example.apimanagerrebuild.models.Category;
import com.example.apimanagerrebuild.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired CategoryService catService;
    @PostMapping("/add")
    public void addOrUpdateCategory (@RequestBody Category c){
        catService.addOrUpdateCategory(c);
    }
    @DeleteMapping("/delete/{idCat}")
    public void deleteCategory(@PathVariable("idCat")Long idCat){
        catService.deleteCategory(idCat);
    }

    @GetMapping("/findById/{idCat}")
    public Category findById(@PathVariable("idCat") Long id){
        return catService.findById(id);
    }



    @GetMapping("/lisAll")
    public List<Category> listAll(){
        return catService.listAll();
    }
}
